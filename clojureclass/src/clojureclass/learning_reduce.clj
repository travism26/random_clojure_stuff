(ns clojureclass.learning-reduce
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan
                     sliding-buffer dropping-buffer unblocking-buffer?
                     pipeline go-loop pipeline-blocking]]))



(defn f1 []
  (println "hello world eh"))

(defn f2 []
  (println "REDUCE FN")
  (println (reduce + 1 [2 3 4 5 6]))
  
  (println "Async reduce time")
  (let [c (chan)]
    (go (println (<! (async/reduce + 1 c))))
    (>!! c 2)
    (>!! c 4)
    (>!! c 6)
    (>!! c 8)
    (async/close! c)
    (<!! (timeout 1000)))
  )

(defn concat-upper-case [s1 s2]
  (str s1 (clojure.string/upper-case s2)))

(defn f3 []
  (let [c (chan)]
    (go (println (<! (async/reduce concat-upper-case "eh? " c))))
    (onto-chan c ["this" "is" "a" "testing" "thingie"])
    (<!! (timeout 100))))
