(def hm (java.util.HashMap. {:key "value"}))
(println hm)
;run instance methods (.methodName Object args)
(doto hm (.put :name "test"))
(println hm)

;(ClassName/staticMethod args)
(Float/parseFloat "3.14159")
(Double/parseDouble "4.1111112")
;(.field object) have an object and want to access one of the object fields?
(def p (java.awt.Point. 10 20))
(println p)
(.x p)
(.y p)
;can we set / mod them?
(set! (.y p) 5)
(set! (.x p) -7)

(println p)

; proxy java class'

;this is how we do it now for examples
;(proxy [class-and-interface] [args] fs+)

;extend the Object class

(defn proxy-example
  []
  (proxy [Object] []
    (toString [] "Hello World")))

(println (.toString (proxy-example)))

(defn proxy-collection []
  (proxy [java.util.Collection] []
    (add [o]
      (println "PROXY:" o)
      true)
    (clear []
      (println "proxy clearing eh")
      true)))
(.add (proxy-collection) "adding an item eh")
(.add (proxy-collection) "adding something else eh")
(.clear (proxy-collection))



