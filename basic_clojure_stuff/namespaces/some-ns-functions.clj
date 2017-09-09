(ns some-ns-functions
  (:use [clojure.string :only [split]]))

(defn split-on-digits [s]
  (split s #"\d+"))

(println (split-on-digits "a1b2c3d4"))
