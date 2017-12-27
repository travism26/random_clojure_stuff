(def eh 15)

(println eh)

(def n (atom 15 :validator pos?))

(println @n)
(swap! n inc)
(compare-and-set! n 16 9876)

(println @n)

(def data (atom {:name "t-rav" :email "mtravis@ca.abc.com"} :error-mode :continue))
(set-validator! data :email)
;(swap! data dissoc :email)
(println @data)

(def nums (atom [2 4 8] :validator #(every? even? %)))
(swap! nums conj 6)
(println @nums)
;(swap! nums conj 9)

(set-validator! nums #(every? pos? %))
;(swap! nums conj -10)

(set-validator! nums nil)
(swap! nums conj -9)
(println @nums)



