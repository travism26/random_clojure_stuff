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

(defn f2 []
  (println (transduce (comp (filter even?) (map inc)) + (range 10))))


(def input-data [
                "St John, NB"
                "Moncton, NB"
                "Quebec City, Quebec"
                "The Rockies, BC"
                "Gesgapegiag, Canada"
                ])

(defn i-live-in [s]
  (format "I live in %s." s))

(defn past-tense [s]
  (clojure.string/replace s #"live" "have lived"))

(defn f3 []
  (println (i-live-in "Canada eh"))
  (println (past-tense (i-live-in "Gesgapegiag")))
  )

(def my-xform
  (comp
   (map i-live-in)
   (map past-tense)))

(defn test-xform []
  (println (sequence my-xform input-data)))


(println "using channels \n")

(def my-xform-chan (chan 1024 my-xform))

(defn f4 []
  (go (loop []
        (println "read:" (<! my-xform-chan))
        (recur)))
  
  (doseq [item input-data]
    (println "putting item: " item)
    (>!! my-xform-chan item))

  )
