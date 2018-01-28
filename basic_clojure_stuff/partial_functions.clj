; partial functions and anonymous functions
((partial + 5) 6 4 8)

(map (partial + 5) [3 4 5]) ; 8 9 10

(def add-fifty (partial + 50))

(println (add-fifty 10 20))
; (println (add-fifty [2 3 4])) doesnt work 

(println (map add-fifty [10 12 13]))

(def partial-one
  (partial conj ["hello" "travis" "whats up"]))

(println (partial-one "Not" "much"))

(def partial-two
  (partial conj [] "this" "is a" "conj"))

(println (partial-two "canada" "eh"))

(println ((partial + 2) 2 3 4 5 6))

(println ((fn [& unfixed-args] (apply + (concat [2] unfixed-args))) 2 3 4 5 6))

