(def a1 (agent ""))

(send a1 (fn [_]
           (throw (Exception. "oh uh"))))

;(send a1 identity)



(def d (agent (java.util.Date.)))

(send d inc)

(agent-error d)

(restart-agent d 10)

(println @d)

(send d inc)
(println @d)

(def d (agent (java.util.Date.) :error-mode :continue))

(send d inc)
(send d identity)

(def d-hardcore (agent 
                 (java.util.Date.)
                 :error-mode :continue
                 :error-handler (fn [a e]
                                  (println (.getMessage e)))))
(println "hardcore agent with error handler")
(send d-hardcore inc)

