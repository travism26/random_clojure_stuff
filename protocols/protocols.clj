; polymorphism
; polymorphic functions -- i think?
(defprotocol MyProtocol 
  (myprint [this]) 
  (mycount [this]))

(deftype MyType [s] 
  MyProtocol 
  (myprint [this] (println s)) 
  (mycount [this] (count s)))

(mycount (MyType. "sup!"))
(myprint (MyType. "hello guy what up"))

(defprotocol PaymentProtocol
  (ProcessPayment [this]))

(deftype CashPayment [s]
  PaymentProtocol
  (ProcessPayment [this] 
    (println "do some payment with cash:\t" s "$")
    (str "Cash payment happening amount:\t" s "$")))

(deftype MoneyTransfer [dollar-amount]
  PaymentProtocol
  (ProcessPayment [this]
    (println "money transfer thingie here:\t" dollar-amount "$")
    (str "Do some money transfer with:\t" dollar-amount "$")))

(deftype CreditCahdPayment [cost account]
  PaymentProtocol
  (ProcessPayment [this]
    (println (str "Cost of item: " cost "$ sending payment to account: " account))))


(def cash-output (ProcessPayment (CashPayment. 5)))
(def transfer-output (ProcessPayment (MoneyTransfer. 15)))
(def credit-output (ProcessPayment (CreditCahdPayment. 4 123)))
(println cash-output)
(println transfer-output)

(defprotocol PointProtocol
  (print [this])
  (diff [this other]))

(deftype Point [x y]
  PointProtocol
  (print [this] (println "Point:" x y))
  (diff [this other] 
    (list (- (.x this) (.x other)) (- (.y this) (.y other)))))

(print (Point. 2 4))
(println (diff (Point. 2 5) (Point. 4 10)))

(comment donno wtf i was doing here...
  (defprotocol eh
      (request [this])
    (process [this])))

