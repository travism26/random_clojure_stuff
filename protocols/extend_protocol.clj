(defprotocol XMLNode
  (as-xml [this]))

(extend-protocol XMLNode
  String
  (as-xml [this] (str "<string>" (identity this) "</string>")))

(println (as-xml "hello, world!"))


(deftype A [a1 a2])
(println (.a1 (A. "hello" "travis")))
(println (A. "nope" "hell nope!"))

(defrecord B [b1 b2])
(println (.b2 (B. "this" 12.2)))
(println (B. "eh" "yup"))


