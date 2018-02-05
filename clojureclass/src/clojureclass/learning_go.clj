(ns clojureclass.learning-go
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]))

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

(defn channels []
  (let [in (chan)
        out (chan)]
    (go (println "Given: " (<! in))
        (>! out "hello world"))
    [in out]))


