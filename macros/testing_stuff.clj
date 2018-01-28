(def va "Canada eh almost made it")
(defmacro test [exp a b]
  (if (not exp) a b))

(println `va)

(println `(test false "t" "f"))

(println 'Hello)
(println `va)

(def va2 "world")

(list `println `va `va2 va)

(println `(println va va2 ~va)) 
