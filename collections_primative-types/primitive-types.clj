(ns primative-types )

(println "hello world")


;C-x C-e
(clojure.string/blank? "")
(clojure.string/blank? "hello travis")
(clojure.string/upper-case "whats up")
(clojure.string/lower-case "THE IS A TEST")
(clojure.string/capitalize "sup")


(symbol "name")

(print (str `name))

(name :someKeyword)

(str :somekeyword)

(use '[clojure.string :only (lower-case)])
;(use '[clojure.string :only (split)])

(print (lower-case "Some String Values Here: Hi, MAN, SUP, SBTREV"))
