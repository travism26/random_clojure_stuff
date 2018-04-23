(ns clojureclass.webscraper
  (:require [clojure.core.async :as async :refer [>!! <!! chan]]
            [org.httpkit.client :as http]
            [net.cgrand.enlive-html :as html]))

(use 'clojure.pprint)

(def default-page "http://www-01.ibm.com/support/docview.wss?uid=swg1IV91030")
(defn get-dom [webpage]
  (html/html-snippet
   (:body @(http/get (if (not (empty? webpage)) webpage default-page) {:insecure? true}))))

; lets get the apar title
(defn extract-titles 
  [dom]
   ;(comp first :value)
  ;(zipmap fields)
  (html/select dom [(html/attr= :type "hidden" :id "categorytitle")])
  )

(defn f1 []
  ;(println (get-dom ""))

  (let [titles (extract-titles (get-dom ""))]
    ;(doall (map println titles))
    (get-in titles [:attrs :id])
    (pprint titles)
    )
  )



