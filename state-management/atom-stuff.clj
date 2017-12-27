
(def t-rav (atom {:name "trav" :age 22 :staus "cool"}))

;@t-rav

(println (@t-rav :name))

(:age @t-rav)

(swap! t-rav assoc :age 25)

(println @t-rav)

(def t (atom {:name "sbt" :age 33 :status "kinda cool" :hair "bald"}))

(println @t)

(def age (atom 10))

(compare-and-set! age 0 20)

(compare-and-set! age 10 15)

;(@age)

(reset! age 21)
(println @age)

(def person 
  (atom 
   {:name "johnson" :age 88 :city "new city" :isPro false}
   :meta {:creation-data "20171227"}
   ))

;(println @person)

(defn f1 [new-city]
  (swap! person assoc :city new-city))

(defn birthday []
  (swap! person assoc :age (+ (@person :age) 1)))

(println @person)
(println (meta person))

(f1 "canada eh")

(println (str "this is new city: " @person))

(birthday)
(println @person)

(def matt 
  (atom {
         :name "tester two"
         :dob "10-sep-99"
         :email "hello-man@ca.travis.com"
         }))

(println "starting...")
(future 
  (swap! matt
         (fn [m]
           (Thread/sleep 300)
           (println "trying to add location")
           (assoc m :location "Canada")
           )))
(println "Starting 2...")
(future
  (swap! matt
         (fn [m]
           (Thread/sleep 400)
           (println "trying to add zip")
           (assoc m :zip "E3B247")
           )))

(Thread/sleep 3000)
(println @matt)

(def month (atom 11))

(compare-and-set! month 11 12)

(println @month)
