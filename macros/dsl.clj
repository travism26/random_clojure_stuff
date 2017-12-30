(defn xml-helper [form]
  (if (not (seq? form))
    (str form)
    (let [name (first form)
          children (rest form)]
      (str "<" name ">"
           (apply str (map xml-helper children))
           "</" name ">"))))

(defmacro xml [form]
  (xml-helper form))

;(println (macroexpand-1 '(xml "<hello>travis</hello>")))


(println 
 (xml 
  (:book
   (:authors
    (:author "Travis")
    (:author "sbt")))))
(println 
 (xml 
  (:user
   (:firstname "t-rav")
   (:lastname "martin")
   (:email "t-rav@ca.abc.com"))))

