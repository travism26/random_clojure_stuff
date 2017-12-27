
; Three types of data types to consider
;1) atoms
;2) refs
;3) Agents

(def atom-data (atom { :info "this is how we do it!"}))

(def ref-data (ref {:info "this is also how we do it!"}))

(def agent-data (agent {:info "agent style"}))


(def r1 (ref [2 3 4]))
;(@r1)
(deref r1)

(first @r1)
(first (deref r1))

(def person (ref {:name "trav"
                  :age 22
                  :email "abc@ca.abc.com"}))

(println (deref person))
(println @person)
(println (+ (@person :age) 1))

(def r2 (ref {:name "travis"}))
(dosync (ref-set r2 {:age 99}))
(dosync (ref-set r2 (assoc @r2 :name "t-rav")))

(dosync (alter r1 conj 8))

(def counter (ref 0))
(dosync (commute counter inc))
(println @counter)

(def numbers (ref [1 2 3 4]))

(defn add-number [ns n]
  (dosync (alter ns conj n)))

(println @numbers)
(add-number numbers 8)
(println @numbers)

(def data (ref {}))
(dosync (ref-set data (assoc @data :color "purple")))
(println @data)
(dosync (alter data assoc :shape "square"))
(println @data)
