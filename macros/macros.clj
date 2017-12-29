(defmacro postfix-notation
  [expression]
  (conj (butlast expression) (last expression)))

(println (postfix-notation (1 10 +)))
(println (postfix-notation (10 2 /)))
(println (postfix-notation (50 2 *)))

(defmacro unless [pred a b]
  `(if (not ~pred) ~a ~b))

(unless false (println "will print") (println "not printing"))

(println (macroexpand-1 '(postfix-notation (1 1 +))))
(println (macroexpand-1 '(postfix-notation (x y *))))
(println (macroexpand-1 '(unless true (dosomething x y z) (dosomethingelse a b c))))

;(println (macroexpand-all '(unless true (dosomething a b c) (doelse a b c))))

(defmacro get-list [s1] (list 'println s1))
(println (macroexpand-1 '(get-list "hello world")))
(get-list "hello")

(defmacro for-loop [[sym init check change :as parmas] & steps]
  `(loop [~sym ~init value# nil]
     (if ~check
       (let [new-value# (do ~@steps)]
         (recur ~change new-value#))
       value#)))

(for-loop [i 0, (< i 10), (inc i)]
          (println i))

