
;first class functions
(defn callf [f s] (f s))

(callf println "hello")

(println (map pos? [1 -2 4 5 -4]))

(map clojure.string/lower-case ["HELlo" "TRAVIS" "whaTS" "Up"])

;function within the first class function
(println (map #(* 5 %) [1 2 3 4 5]))

(reduce min [1 4 -2 10 6])


