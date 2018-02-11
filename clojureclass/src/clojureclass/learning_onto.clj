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

(defn f1 []
  (println "starting...")
  (let [c (chan)]
    
    (close! c)
    (go (println "putting..." (>!! c "hello")))
    ;(println "read:" (<!! c))

    (<!! (timeout 100))))

(defn f2 []
  (let [c (chan)]
    (go
      (println "Take:" (<! c))
      (println "Take:" (<! c))
      (println "Take:" (<! c))
      (println "Take:" (<! c))
      )
    
    ;(close! c)
    (loop [items [2 4 6 7]]
      (when-let [item (first items)]
        (println "returned:" (>!! c item))
        (recur (rest items)))
      )
    (<!! (timeout 1000))
    (println "\nALL DONE")))

(defn f3 []
  (let [c (chan)]
    (go
      (println "take: " (<! c))
      (println "take: " (<! c))
      (println "take: " (<! c))
      (println "take: " (<! c))
      )

    (close! c)
    (loop [items [2 4 5 6]]
      (when-let [item (first items)]
        (when (>!! c item)
          (println "put: " item)
          (recur (rest items)))))
    (println "\nALL DONE")))
