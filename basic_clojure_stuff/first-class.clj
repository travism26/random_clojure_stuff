(defn simple-f [s]
  (println "in simple-f: " s)
  (fn [s2]
    (str "in the returned function: " s2)))

(println ((simple-f "testing this function") "second args passed to func"))


(defn make-adder-function [x]
  (let [y x] 
    (fn [z] (+ y z))))

(def add2 (make-adder-function 2))
(def add25 (make-adder-function 25))
(def add-float (make-adder-function 3.14256159))

(println (add2 4))
(println (add25 75))
(println (add-float 3))

()
