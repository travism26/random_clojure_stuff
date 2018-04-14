(ns clojureclass.learning-reduce
  (:require [clojure.core.async
             :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout put! take! onto-chan
                     sliding-buffer dropping-buffer unblocking-buffer?
                     pipeline go-loop pipeline-blocking]]))



(defn f1 []
  (println "hello world eh"))

(defn f2 []
  (println "REDUCE FN")
  (println (reduce + 1 [2 3 4 5 6]))
  
  (println "Async reduce time")
  (let [c (chan)]
    (go (println (<! (async/reduce + 1 c))))
    (>!! c 2)
    (>!! c 4)
    (>!! c 6)
    (>!! c 8)
    (async/close! c)
    (<!! (timeout 1000)))
  )

(defn concat-upper-case [s1 s2]
  (str s1 (clojure.string/upper-case s2)))

(defn f3 []
  (let [c (chan)]
    (go (println (<! (async/reduce concat-upper-case "eh? " c))))
    (onto-chan c ["this" "is" "a" "testing" "thingie"])
    (<!! (timeout 100))))

; Messing around with this going to try and include reduce and protocols in this.
; run a set of protocols in with some input? will this work, stay tuned...

; Try creating different loggers and parsers?
(defprotocol logger
  (log-message [this])
  (some-logging [this]))

(deftype LogInfo [s] 
  logger
  (log-message [this] (println (str "Logging [INFO]: " s)))
  (some-logging [this] (println (str "Canada eh, almost made it: " s))))

(deftype LogError [s]
  logger
  (log-message [this] (println (str "Logging some [ERROR]: " s)))
  (some-logging [this] (println (str "loggin something [ERROR something]: " s))))

(deftype LogWarn [s]
  logger
  (log-message [this] (println "eh? [WARN]: " s))
  (some-logging [this] (println "something [WARN]: " s)))

(def info LogInfo )
;(def err log-error.)
;(def warn log-warn.)
(defn f4 []
  (println "testing my logger")
  (log-message (LogInfo. "travis martin"))
  (log-message (LogError. "eh")))

; I dont like how this is layed out, there has to be an easier way to do this?
; Polymorphic functions more `gooder` and will replace this...
(defn generate-log [logger message]
  (cond
    (= (clojure.string/lower-case logger) "error")
    (log-message (LogError. message))
    (= (clojure.string/lower-case logger) "info")
    (log-message (LogInfo. message))))


(defn f5 []
  (generate-log "error" "TRAVIS ERROR MESSAGE")
  (generate-log "iNFO" "this is an info log message"))
