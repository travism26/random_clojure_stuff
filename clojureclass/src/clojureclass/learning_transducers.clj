(ns clojureclass.learning-transducers
    (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan
                     sliding-buffer dropping-buffer unblocking-buffer?]]))

(defn f1 []
  (def xf
    (comp
     (filter even?)
     (map inc)))
  (println (transduce xf + (range 10)))
  )
