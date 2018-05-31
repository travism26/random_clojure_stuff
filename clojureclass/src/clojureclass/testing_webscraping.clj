(ns clojureclass.testing-webscraping
  (:require  [clojure.test :as t]))

(use 'clojure.pprint)

(def data (lazy-seq {:tag :input,
                :attrs
                {:type "hidden",
                 :name "categorytitle",
                 :id "categorytitle",
                 :value "APAR IV91030: QRADAR APPS THAT REQUIRE SPECIFIC USER ROLE PERMISSIONS CAN STOP WORKING AFTER PATCHING TO QRADAR 7.2.8 PATCH 1"},
            :content nil}))

(defn run []
  (pprint data)
  
  (println (type data))
  (println (map #(get-in % [:attrs :value]) data))
  )
