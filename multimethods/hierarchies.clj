(derive ::mammal ::animal)
(derive ::reptile ::animal)
(derive ::dog ::mammal)
(derive ::snake ::reptile)
(isa? ::dog ::mammal)
(isa? ::dog ::reptile)
(isa? ::dog ::animal)
(isa? ::snake ::mammal)
(isa? ::snake ::reptile)
(isa? ::snake ::animal)


(defmulti area
  (fn [s] (:shape s)))
(defmethod area :rectangle [r]
  (* (:width r) (:height r)))
(defmethod area :circle [c]
  (* (. Math PI) (:radius c) (:radius c)))
(defmethod area :default [s]
  42)
(defmethod area :triangle [t]
  (/ (* (:base t) (:height t)) 2))


(println (area {:shape :circle :radius 12}))
(println (area {:shape :notashape}))
(println (area {:shape :rectangle :height 10 :width 2}))
(println (area {:shape :triangle :base 5 :height 10}))


(derive ::square ::rectangle)
(println (area {:shape ::square :height 5 :width 5}))
;(println (area {:shape :rectangle :height 5 :width 5}))

(derive ::othercircle ::circle)
(println (area {:shape :othercircle :radius 1}))
