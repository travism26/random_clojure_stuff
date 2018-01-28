

(+ 3 4 5)

(str (+ 3 4 5))

(println (keyword (str (+ 3 4 5))))

(println ((comp keyword str +) 3 4 5))

(not (zero? 1))

((comp not zero?) 1)


(println ((comp clojure.string/lower-case clojure.string/trim) "  HelLo wOrlD     "))

(println (count (str 1 3 2 5 6)))

(println ((comp count str) 1 3 2 5 6))
