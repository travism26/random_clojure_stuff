
(defprotocol MyProtocol 
  (myprint [this]) 
  (mycount [this]))

(deftype MyType [s] 
  MyProtocol 
  (myprint [this] (println s)) 
  (mycount [this] (count s)))

(mycount (MyType. "sup!"))
(myprint (MyType. "hello guy what up"))
