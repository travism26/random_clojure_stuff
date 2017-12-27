(def a1 (agent 1336))

(println @a1)
(send a1 inc)
(println @a1)

;(shutdown-agents)
(println @a1)

