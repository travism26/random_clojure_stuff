(ns clojureclass.learning-httpkit
  (:require [clojure.core.async :as async :refer [>!! <!! chan]]
            [org.httpkit.client :as http]))


(defn eh []
  (println "ehello"))
