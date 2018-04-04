(ns clojureclass.learning-httpkit
  (:require [clojure.core.async :as async :refer [>!! <!! chan]]
            [org.httpkit.client :as http]))


(defn eh []
  (println "canada eh, almost made it."))


(defn google-search [query]
  (let [c (chan)
        url (str "https://www.google.com/search?q=" query)]
    (println "    URL:" url)
    (http/get url (fn [resp] (>!! c resp)))
    c))

(def cache (atom {}))
(defn my-cache [query]
  (println "processing: " query)
  (if-let [resp (get @cache query)]
    (str "    existing:" (count (:body resp)))
    (let [new-resp (<!! (google-search query))]
      (swap! cache assoc query new-resp)
      (str "    new:" (count (:body new-resp))))))


(defn run-search []
  ;(println (<!! (google-search "clojure")))
  (println (my-cache "travis"))
  (println (my-cache "travis"))
  (println (my-cache "travism26"))
  (println (my-cache "Gesgapegiag"))
  (println (my-cache "Gesgapegiag"))
  )
