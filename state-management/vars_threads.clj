(def ^:dynamic v 10)
(def ^:dynamic p 22)

(println v)
(println p)

;(+ v p)

(binding [v 20 p 8] 
  (* v p))

(def ^:dynamic extension)
(defn generate-filename []
  (str "my-file." extension))
(binding [extension "json"]
  (println (generate-filename)))

(binding [extension "txt"]
  (println (generate-filename)))

(println "global:" extension)


