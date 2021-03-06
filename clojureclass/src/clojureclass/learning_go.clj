(ns clojureclass.learning-go
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! go-loop]]))

(defn myf []
  (println "hello"))


(defn chan-stuff []
  ;(println (chan))
  ; Chan creates a channel
  ; - channels are used to send messages
  ; - connunication over a channel is an event that is handled
  ; - messages can be put on a channel
  ; - messages can be taken off a channel
  ; - messages put or taken will block until they are taken or put
  
  (chan)
  
  (def example-chan (chan))
  (println example-chan)

  ; close the channel when  it is no longer needed
  (close! example-chan)

  ; create channel with a buffer size 3
  ; thereby allowing more then one message to be put
  ; before it blocks

  (def example-chan2 (chan 3))
  (>!! example-chan2 "one")
  (>!! example-chan2 "two")
  (>!! example-chan2 "three")
  (println "blocking")
  ;(>!! example-chan2 "forth")
  (println "BLOCKED?")

  ; can use buffer to create a buffer

  (def example-chan3 (chan (buffer 2)))

  (>!! example-chan3 "trav")
  (>!! example-chan3 "jon")
  (println "going to block")
  ;(>!! example-chan3 "jim")
  (println "NEVER REACHED")
)

; puts:
;   inside `go` blocks: >! or >!!
;   outside `go` blocks: >!!
; takes:
;   inside `go` blocks: <! or <!!
;   outside `go` blocks: <!!

; blocking functions:
; - <!! and >!!
; - familar thread waiting.
; - waits for something to happen.
; - creates a seperate action waiting for something else.

; Parking functions
; - <! and >!
; - only possible within a `go` blocks
; - different type of thread waiting put waits on take and vice verse
; - moves the waiting task off the thread, freeing it up
; - moved back on when ready to be processed
; - interleaves multiple takes on a single thread
(defn parking-fn []
  (println "\n-----")
  (def lots-of-tasks-chan (chan))
  (doseq [n (range 100)]
    (go (>! lots-of-tasks-chan (str "Travis, M:" n))))
  (doseq [n (range 10)]
    (println (<!! lots-of-tasks-chan)))
  )

(defn two-channels []
  (let [in (chan)
        out (chan)]
    (go (println "Given: " (<! in))
        (>! out "hello world"))
    [in out]))

(defn run-channel []
  (let [[in-chan out-chan] (two-channels)]
    (>!! in-chan 12)
    (println "received: " (<!! out-chan))))

(defn fun-with-let []
  (let [c (chan)]
    (println "Starting the let block....")
    ; This will block? outside the go block
    ;(>!! c "testing 1")

    ; >!! blocks until the channel is ready
    ; <!! takes outside a go block - blocks eh
    ; this is never reached though
    
    ;(println "take off the queue aka chan")
    ;(println (<!! c))

    ; >! puts to a channel - inside a go block - parks
    (go (>! c "testing 2"))

    ; <! takes from a channel - inside go block - parks
    (go (println (<! c)))

    ; `timeout` will create a channel that closes in a passed in miliseconds
    (<!! (timeout 100))
    
    (go (println (<! c)))
    (>!! c "testing 3 dude")
    (<!! (timeout 100))

    (put! c "test 4" (fn [v] 
                       (println "in put! f:" v)))
    
    (take! c (fn [v] 
               (println "in take! f:" v)))

    (<!! (timeout 100))
    
    (println "all done bruh")
    )
  )

(defn f2 []
  (def c (chan 1024))
  (go (println (<! c))
      (println "I read something from c"))
  (>!! c "this is a test")
  (<!! (timeout 100))
  )

(defn f3 []
  (def c (chan 1024))
  (go-loop [seconds 1]
  ; `timeout` returns a channel that will close in give number of mill secs
    (<! (timeout (* seconds 1000)))
    (println "waited " seconds "seconds")
    (recur (inc seconds)))
  (read-line)

  (go-loop []
           (let [x (<! c)]
             (println "received:" x))
           (recur))

  (doseq [n (range 3)]
    (>!! c n))
  (read-line)
  )

(defn fake-search [search-type]
  (fn [q]
    (let [c (chan)]
      (go
        (<! (timeout (rand-int 5000)))
        (>! c (str "result for " search-type ":" q)))
      c)))

(def web-search (fake-search "web"))
(def image-search (fake-search "image"))
(def video-search (fake-search "video"))

(defn search-engine [q]
  (let [c (chan)]
    (go (>! c (<! (web-search q))))
    (go (>! c (<! (image-search q))))
    (go (>! c (<! (video-search q))))
    (go-loop []
      (let [x (<! c)]
        (println "received: " x))
      (recur)))
  )

(defn f4 []
  (search-engine "testing")
  (read-line))


(defn f5 []
  (def c1 (chan 1024))
  (def c2 (chan 1024))
  (go (let [s1 (<! c1)
            s2 (str s1 " eh almost made it")]
        (>! c2 s2)))
  
  (>!! c1 "Canada,")
  (println "read from c2: " (<!! c2)))


(defn f6 []
  (def my-chan (let [c (chan)]
                 (go (>! c "testing 1 3 2"))))

  (println my-chan)
  (go (>! my-chan "sent to my-chan"))
  (println "got:" (<!! my-chan))
  )
