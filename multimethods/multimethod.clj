;how multimethods work?
; 1) take args
; 2) compute dispatch value with passed in args
; 3) select method based on dispatched value
; 4) call method with org argument

; lets try this out!


(defmulti simple (fn [o] (:value o)))
(defmethod simple 2 [o] (println "2!"))
(defmethod simple 4 [o] (println "4!"))
(defmethod simple :default [o] (println "neither 2 nor 4:" o))

(simple {:value 2})
(simple {:value 3})
(simple {:value 4})
(simple {:value 5})
(simple {:value 6})

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

