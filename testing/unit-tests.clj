(ns some-namespace.unit-tests
  (:use clojure.test))

(println "\n Starting...")
(run-all-tests)

(is (= 4 4))

(is (not (= 4 5)))

(is (instance? Double 5.44))
(is (instance? Float 5.44))

(println (is (= 4 4)))
(println (is (= 5 2)))

(is (= 12 (* 6 3))
    "Does 12 equal 6 * 2?")

;testing in groups

(testing "Testing bools"
  (is true)
  (is false))

(testing "String" 
  (testing "equality"
    (is (= "hello" "helloo") "testing hello eh")
    (is (not (= "hello" "sbt"))))
  (testing "startsWith"
    (is (.startsWith "hello" "he"))
    (is (not (.startsWith "hello" "trav")))))


(with-test
  (defn add-ten [i]
    (+ i 10))
  (is (= 12 (add-ten 2)) "this is the add ten test")
  (is (= 15 (add-ten 1))))

(deftest mult
  (is (= 12 (* 6 2)))
  (is (= 18 (* 6 3))))

(run-tests 'some-namespace.unit-tests)
