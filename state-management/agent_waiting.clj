;(def m (agent {}))
;(send m (fn [a] (Thread/sleep 10000) (assoc a :done true)))

(def a1 (agent 2000))
(def a2 (agent 6000))
(send-off a1 #(Thread/sleep %))
(send-off a2 #(Thread/sleep %))
(println @a1)
(println "Waiting...")
(await a1 a2)
(println "done")



