(defn print-watch [key thing old new]
  (println key ":" old "=>" new))

(def m (atom {:value 10}))

(println @m)

(swap! m update-in [:value] inc)
(println @m)

(add-watch m :print-it print-watch)
(swap! m update-in [:value] inc)

(defn warn-watch [k t o n] 
  (println "WARNING:" k "changed from" o "to" n))
(def person (atom {:name "travis" :email "abc@ca.abc.com"}))
(add-watch person :logger warn-watch)

(swap! person assoc :name "martin")

(def history (atom ()))

(defn keep-history 
  [history-atom k i o n]
  (if (not= o n)
    (swap! history-atom conj n)))

(def data (atom {:name "johnson" :email "johnson-n-johnson@canada.ca"}))

(add-watch data :history-data (partial keep-history history))

(println "\nStarting.....")
(swap! data assoc-in [:age] 29)
(swap! data update-in [:age] inc)
(swap! data update-in [:age] inc)
(swap! data assoc-in [:city] "Quebec City")
(swap! data assoc-in [:age] 31)

(pprint history)
