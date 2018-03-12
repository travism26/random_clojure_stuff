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

