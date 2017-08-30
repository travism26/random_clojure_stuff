
(defn g [n]
  (str "in g():" n))

(defn f [n]
  (println (str "in f(): " (g n))))

(f 12)

(defn sums [n]
  (if (= n 1)
    1
    (+ n (sums (- n 1)))))

(println (sums 4))
(println (sums 10))

(defn sums-tail [s n]
  (if (= n 1)
    (+ s 1)
    (sums-tail (+ s n) (dec n))))


(println (sums-tail 0 5))
(println (sums-tail 0 10))
;(println (sums-tail 0N 10000)) this breaks it, to many functions call on the stack. loop recur maybe?

(loop [nums [2 4 6 8 10]]
  (if-let [n (first nums)]
    (do
      (println "n:" n)
      (recur (rest nums)))))

(def sentence "this is my phone number 1-888-555-1337")
(def digit-match #"[0-9]")
(def matcher (re-matcher digit-match sentence))

(loop [match (re-find matcher)
       digits []]
  (if-not match
    (println digits)
    (recur (re-find matcher)
           (conj digits match))))


