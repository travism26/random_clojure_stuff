(ns clojureclass.learning-reduce
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan
                     sliding-buffer dropping-buffer unblocking-buffer?
                     pipeline go-loop pipeline-blocking]]))



(defn f1 []
  (println "hello world eh"))
