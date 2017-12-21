(def v [4 3 :travis])

(def v (vec [1 2 3 3]))

(println v)

(println (vec {:a 2 :b 23 :c "travis"}))


(def l '(2 4 5)) 

(println l)

(type '(2 4 :r "hello"))

(list 2 5 6 :23 'hello)

(def t 25)

'(2 4 x)

(list 2 4 t)

(list? '(2 4 6))
(list? (list 2 3 5 t))


; VECTORS

(type [3 4 :34 "travis"])

(vector 2 15 "hello world" 'sym)

(into [] '("some list" 2 5 :username))

(def v [2 "5" :10 20.0])

(println (conj v 100))

(println v)

(println (last v))
(println (nth v 2))
(println (get v 3))

(println (get v 5 "default"))

(v 2)

(assoc v 2 "new value" 3 "canada eh")

{:name "travos" :age 99 :city "fredericton"}

(array-map :city "freddy" :name "trav" :age 99)

(zipmap [:name :age :phone]  ["travis" 98 "555-1232"])

(def fruit {:red "green apple..." :yellow "banananananana" :blue "blue stuff"})

(get fruit :red)

(get fruit :yellow)

(get fruit :orange "default")

(fruit :yellow)
(:yellow fruit)

(get-in fruit [:red]) ;useful for nested maps

(def person2 {:name "trav" :phone {:cell "1234" :home "4321"}})

(get person2 :name)
(get person2 :phone) ;returns both

(get-in person2 [:phone :cell])

(def v-data [{:name "trav"} {:name "SB-trev"} {:name "SBK"}])

(get-in v-data [1 :name])

(defn biggest-sb [n]
  (if (= n 0)
    (println (str "the biggest SB is: " (get-in v-data [1 :name])))
    (println (get-in v-data [2 :name]))))

(defn test-fn [n]
  (def a "the SB is: ")
  (let [x n]
    (if (= n 0)
      (str a (get-in v-data [1 :name]))
      (str a (get-in v-data [2 :name])))))

(biggest-sb 1)

(test-fn 0)

(def food {:breakfest "eggs" :lunch "bacon" :supper "sandwich"})

(assoc food :breakfest "pancakes")

