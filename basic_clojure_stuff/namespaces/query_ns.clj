;(println (all-ns))

;(println (ns-publics `clojure.string))

(println (keys (ns-publics `clojure.string)))

;(dir clojure.string)
(ns new-ns)
(intern 'new-ns 'new-variable "a new value two")

(def v 10)

(ns-unmap 'user 'v)

;OR 
(ns-unmap *ns* 'v)
