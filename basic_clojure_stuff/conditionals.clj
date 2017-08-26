

(if nil "true" "false")
; false

(if false "eh" "canada eh almost made it")

(if 1 "Game of thrones" "nothing to see here")

(if-not 1 "this is true" "false")

(if-let [x 10] "true" "false")
(if-let [x false] "true" "false")

(println (if [] "true" "false"))
(println (if [nil] "true" "false"))
(println (if (first [nil]) "true" "false"))

(defn do-something [& args]
  (if-let [first-arg (first args)]
    (str "first arg: " first-arg)
    (str "no args")))

(println (do-something 10 [30 40] 99))
(println (do-something))

