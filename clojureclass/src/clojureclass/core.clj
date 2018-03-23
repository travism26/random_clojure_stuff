(ns clojureclass.core
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]
            [clojureclass.learning-go
             :as learn-go]
            [clojureclass.learning-onto
             :as learn-onto]
            [clojureclass.learning-buffers
             :as learn-buffer]
            [clojureclass.learning-transducers
             :as learn-transducers]
            [clojureclass.pipelines
             :as learn-pipeline]
            [clojureclass.exceptions
             :as learn-exception]
            [clojureclass.learning-httpkit 
             :as learn-httpkit]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(println "Hello, World!")
  ;(learn-go/myf)

  ;(learn-go/chan-stuff)
  
  ;(learn-go/parking-fn)

  ;(learn-go/run-channel)

  ;(learn-go/fun-with-let)
  
  ;(learn-onto/fun-with-flags)

  ;(learn-onto/f3)

  ;(learn-buffer/f1)

  ;(learn-transducers/f3)
  ;(learn-transducers/test-xform)
  
  ;(learn-transducers/f4)

  ;(learn-pipeline/f2)
  ;(learn-exception/f3)
  (learn-go/f6)
  )
