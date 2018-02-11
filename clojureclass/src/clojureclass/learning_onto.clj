(ns clojureclass.learning-onto
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan]]))

(defn fun-with-flags []
  (println "learning onto chan")
  (let [c (chan)]
    (onto-chan c [1 2 3 4 5])
    (doseq [n (range 5)]
      (println "take from chan:" (<!! c)))
    )

  (let [c (chan)]
    (onto-chan c (range 20))
    
    (loop [v (<!! c)]
      (println "read" v)
      (if v
        (recur (<!! c))))
    )
  )
