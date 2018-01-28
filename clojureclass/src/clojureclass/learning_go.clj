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
