(ns clojureclass.learning-buffers
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan
                     sliding-buffer dropping-buffer unblocking-buffer?]]))

(defn f1 []
  (def c1 (chan (buffer 2)))
  (>!! c1 "one")
  (>!! c1 "two")
  (println "print before block")
  ;(>!! c1 "block")
  (println "this is the end")
  
  (println "\n-----")

  ; sliding buffer:
  ; if we put things that go beond its size it removes the oldests value / entry
  ; kinda like the FIFO style.
  (def c2 (chan (sliding-buffer 2)))
  (>!! c2 "one")
  (>!! c2 "two")
  (>!! c2 "three")
  (>!! c2 "four")
  (>!! c2 "five")
  (println "taking from the sliding-buffer1: "(<!! c2))
  (println "taking from the sliding-buffer2: "(<!! c2))

  ; Dropping-buffer:
  ; this will drop all events / entries / values that are attempted to put on the
  ; buffer that is full, this case only returning `one`, `two`. (newest value)
  (println "\n DROPPING BUFFER")
  (def c3 (chan (dropping-buffer 2)))
  (>!! c3 "one")
  (>!! c3 "two")
  (>!! c3 "three")
  (>!! c3 "four")
  (>!! c3 "five")
  (println "from dropping-buffer1: " (<!! c3))
  (println "from dropping-buffer2: " (<!! c3))

  ; `unblocking-buffer` returns true if a channel created with this buffer
  ; will never be full
  (println "\n unblocking buffer-----")
  (println "buffer never full?" (unblocking-buffer? (buffer 2)))
  (println "sliding buffer never full?" (unblocking-buffer? (sliding-buffer 2)))
  (println "dropping buffer never full?" (unblocking-buffer? (dropping-buffer 2)))
  )

