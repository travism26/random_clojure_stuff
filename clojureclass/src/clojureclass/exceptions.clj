(ns clojureclass.exceptions
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan
                     sliding-buffer dropping-buffer unblocking-buffer?
                     pipeline go-loop pipeline-blocking]]))

(defn f1 []
  ; Testing some exception handling eh
  (try 
    (assert (= 5 (+ 2 2)) "This should be 4?")
    (catch Throwable ex
      (println "Exception time!")
      (println ex)))
  )


(defn f2 []
  (try
    (/ 1 0)
    (catch Throwable ex
      (println "caught an exception:" (.getMessage ex)))))


(defn f3 []
  (def c (chan 100))
  (go (loop []
        (println "Got:" (<! c))
        (recur)))
  (def channel-data (conj (vec (range 10)) nil 14 16 18))
  (doseq [v channel-data]
    (println "sending: " v)
    
    ; This will break if we try to send a nil!!! wrap around try catch
    ;(>!! c v)

    (try 
      (>!! c v)
      (catch Throwable ex
        (println "Cant put nil on channel")))))
