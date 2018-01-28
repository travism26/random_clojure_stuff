(pmap inc [2 4 6 8 10])
(map inc [2 4 6 8 10])

;takes 20secs
;(time (doall (map (fn [_] (Thread/sleep 4000)) [0 1 2 3 4])))

;takes 4 secs
;(time (doall (pmap (fn [_] (Thread/sleep 4000)) [0 1 2 3 4])))

(defn comp-intensive [n] (Thread/sleep n) n)

;(time (list (comp-intensive 5000) (comp-intensive 2000) (comp-intensive 3000)))

;(time (doall (pvalues (comp-intensive 5000) (comp-intensive 2000) (comp-intensive 3000))))

(defn do-a-lot [] (Thread/sleep 1000) 12)

;(time (list (do-a-lot) (do-a-lot) (do-a-lot)))

(time (doall (pcalls do-a-lot  do-a-lot  do-a-lot)))


(def f (future (println "hello") 42))
;(@f)

(def p (promise))
(realized? p)
(deliver p 42)
(realized? p)
(println @p)

(def future-obj (future
                  (println "future starting...")
                  (Thread/sleep 2500)
                  (println "future done")
                  12))

(println "main future created")
(Thread/sleep 1000)
(println "main stuff")
(println "main future:" @future-obj)
(println "main done")

(def x (promise))
(def y (promise))
(def z (promise))

(future 
  (deliver z (+ @x @y))
  (println "Delivered to z..."))
(deliver x 10)
(deliver y 2)

(println "Z:" @z)
