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

;(type fruit)

(type fruit)

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


; hash-sets do not contain dups
(type #{2 4 5 6}) 

(hash-set 2 5 3 2)

(set [2 :4 "6" 8])

;faster the 'set'
(into #{} '(:2 4 "6"))

(sorted-set 2 1 3 5 9 8)

(def s #{2 4 6 7})

(conj s 10 22 31) 

(disj s 2 6 10)

(contains? s 4)
(contains? s 112)

(get s 4)


; sequences

(seq? '(1 2 3))

(seq? [2 5 6])

(seq '(9 8 7))

(seq {:2 4 :6 8})

(first [2 3 4])

(nth '(2 4 5 6) 2)

(nth [2 4 5] 2)

(cons 2 '(3 5 1))

(cons 5 [2 3 6])

; lazy seq

(defn random-nums []
  (lazy-seq
   (println "read some random numbers")
   (cons (rand-int 100)
         (random-nums))))

(println "starting ran nums")
(def nums (take 10 (random-nums)))

(println "first:")
(println (first nums))
(println "nth")
(println (nth nums 3))

(println "count 1:")
(println (count nums))

(println "count 2:")
(println (count nums))

(seq [9 8 7 6])

(vals {:a "hello" :b "there"}) 
(keys {:a "hello" :b "there"}) 

(range 10)

(distinct [1 2 3 5 1 2])

(filter even? (range 10))

(cons 10 [2 5 9])

(concat '(2 5 1) [6 1 10])
(interleave '(2 5 1) [6 1 10])
(interleave '(2 5 1) [6 1 10] '(:hello :travis :sup))
(rest [2 4 6 8 10])

(reverse "hello")
(reverse [2 3 4 5])
(sort [5 4 3 1 9 8])






