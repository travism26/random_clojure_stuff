;how to measure the time your program takes.

;macro
;(time (+ 1 2))

;(println(macroexpand-1 '(time (+ 2 2))))

;(use 'criterium.core)

(println "Memoize")

(defn myf [n]
  (println "Working with:" n)
  (* n 10))

(println (myf 4))

(def m-myf (memoize myf))

(println (m-myf 14))
(println (m-myf 14))

(println "-----type hits-----")

(defn len [x]
  (.length x))

(defn len2 [^String x]
  (.length x))

;(time (reduce + (map len (repeat 1000000 "Hello"))))
;(time (reduce + (map len2 (repeat 1000000 "Hello"))))

(println "-----transients-----")

(defn vrange [n] 
  (loop [i 0 v []]
    (if (< i n)
      (recur (inc i) (conj v i))
      v)))

(defn vrange2 [n]
  (loop [i 0 v (transient [])]
    (if (< i n)
      (recur (inc i) (conj! v i))
      (persistent! v))))

(time (def v (vrange 100000)))
(time (def v2 (vrange2 100000)))
