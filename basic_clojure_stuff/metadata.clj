(def m ^{:createdDate "20171226"} {:name "john" :age 99})

(println m)
(meta m)

;(def m  (with-meta m {:more "info"}))
(meta m)
(def m (with-meta m (assoc (meta m) :more "info")))

(println (meta m))

(def m2 ^:private ^{:createdDate "20171226"} {:name "jonny" :age 77})

(println m2)
(meta m2)

(def m2 (with-meta m2 (assoc (meta m2) :more "data stuff")))

(meta m2)

(defn ^{:doc "this is function doc string"} f [] 10)

(doc f)

(defn #^{:test (fn [](assert true))} some-fn [] nil)

(test #'some-fn)

