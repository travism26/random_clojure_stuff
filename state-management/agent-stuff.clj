(def a1 (agent 100))

(println @a1)

(send a1 range 150)

(println @a1)

(def a2 (agent 10))

(send a2 + 2)

(println "Starting...")

(def counter (agent 1))
(send counter inc)
(Thread/sleep 500)
(println "counter:" @counter)

(def data (agent {}))
(send data assoc :name "eh")
(send data assoc :email "huh?")
(Thread/sleep 500)
(println @data)

(def file-contents (agent ""))
(send file-contents #(slurp %2) "agent-stuff.clj")
(Thread/sleep 500)
(println @file-contents)


