
(defn change-obj [o]
  (assoc o :age 28))

(def person { :name "travis" })

(println person)

(change-obj person)

;immutable stuff cannot be mod can be overwritten though
(println person)

;overwrite the data with a return value from the function.
(def person (change-obj person))
(println person)
