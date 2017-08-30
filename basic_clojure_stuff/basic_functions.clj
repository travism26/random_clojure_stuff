

(defn add2 [x y]
  (+ x y))

(println (add2 2 3))

(defn overloading 
  ([] 1337)
  ([x] x)
  ([x y] 
   (+ x y)))

(println (overloading))
(println (overloading 14))
(println (overloading 13 14))

; local names create with 'let'
; cannot be change! not like vars
(defn f1 [x]
  (let [y (* x 3)]
    (println "x:" x)
    (println "y:" y)))

(println (f1 3))
(println (f1 20))

(def x "travis")
(defn change [x] 
  (println "x:" x)
  (def x "global_change")
  (println "x:" x))

(change x)

(println x)

;let names and local vars
(defn some-func [x y]
  (let [x (inc x)
        y (inc y)]
    (println "In the let: x" x "y:" y))
  (println "after the let x:" x "y:" y))

(def x 10)
(def y 30)
(some-func x y)
(println "global values: x" x "y" y)

