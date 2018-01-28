
(defn sleep-some [n]
  (Thread/sleep 2000)
  (* n 2))

(println "ex1 with map:")
(time (dorun (map sleep-some (range 5))))
(println "ex2 with pmap:")
(time (dorun (pmap sleep-some (range 5))))

(defn parse-city-state-zip [s]
  (re-seq #"([A-Z][a-z]+), ([A-Z]{2}) (\d+)" s))

(def files (repeat 100
                   (apply str
                          (concat (repeat 1000000 " ")
                                  "Chicago, IL 60601 | Evanston, IL 60201 "))))
(println "ex with map:")
(time (dorun (map parse-city-state-zip files)))
(println "Ex2 with pmap")
(time (dorun (pmap parse-city-state-zip files)))


