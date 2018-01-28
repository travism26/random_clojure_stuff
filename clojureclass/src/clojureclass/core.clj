(ns clojureclass.core
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]
            [clojureclass.learning-go
              :as learning]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (learning/myf)

  (learning/chan-stuff)
  )
