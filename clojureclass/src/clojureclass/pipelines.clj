(ns clojureclass.pipelines
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan
                     sliding-buffer dropping-buffer unblocking-buffer?
                     pipeline go-loop pipeline-blocking]]))


(defn change-string [s]
  (<!! (timeout 1000))
  (str "my string: " s))

(def xf
  (comp
   (map change-string)
   (map clojure.string/upper-case)))

(defn fn1 []
  (let [in (chan 1024)
        out (chan 1024)]
    (pipeline 1 out xf in)
    (go-loop []
      (println (<! out))
      (recur))
    (println "enter text: ")
    (loop [s (read-line)]
      (if s 
        (do
          (>!! in s)
          (println "enter text: ")
          (recur (read-line)))))
    ))

(defn my-fetch [{:keys [url]}]
  (println "Going to fetch from " url)
  (let [data (slurp url)]
    (println "read from:" url)
    {:url url :data data}))

(def xff
  (comp
   (map my-fetch)))

(defn f2 []
  (let [from (chan 1024)
        to (chan 1024)
        my-map (atom {})
        urls [
              "http://amazon.com"
              "http://facebook.com"
              "http://google.com"
              "https://yahoo.com"
              ]]
    (pipeline-blocking 4 to xff from)
    
    (go-loop []
      (let [{:keys [url data]} (<! to)]
        (swap! my-map assoc url data)
        (recur)))
    
    (doseq [url urls]
      (>!! from {:url url}))
    
    (<!! (async/timeout 5000))))
