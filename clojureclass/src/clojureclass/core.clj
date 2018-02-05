(ns clojureclass.core
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]
            [clojureclass.learning-go
             :as learn-go]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  ;(learn-go/myf)

  ;(learn-go/chan-stuff)
  
  (learn-go/parking-fn)
  )
