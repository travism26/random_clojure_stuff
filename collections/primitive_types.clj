(ns collections.primative-types 
                                        ;(:require [collections.mock-data :as md])
  )

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

(def test-data {:name "travis" :info "is a good guy eh" 
                :something-else {:something-here "eh" :github-url "github.com/travism26" :personal-site "dont have one"}})


(defn print-keyword [list-in key]
  (print (first (list-in))))
                                        ;(print-keyword test-data ":hello")

                                        ;(println test-data)

(defn print-vector 
  ([n] 
   (println n))
  ([n k]
   (let [key k]
     (get n key))))

(print-vector test-data)

(def my-name (print-vector test-data :name))

(println my-name)

(def test-data 
  {{:id 1},
   {:id 2}}
  )

(println data)

(def data 
  {{
    :id 1
    :first_name "Thadeus"
    :last_name "Partener"
    :email "tpartener0@skyrock.com"
    :gender "Male"
    :ip_address "34.151.60.9"
    }, 
   {
    :id 2
    :first_name "Solly"
    :last_name "Killingbeck"
    :email "skillingbeck1@ovh.net"
    :gender "Male"
    :ip_address "223.219.205.197"
    }, 
   {
    :id 3
    :first_name "Etti"
    :last_name "Ruffle"
    :email "eruffle2@mozilla.com"
    :gender "Female"
    :ip_address "91.92.0.5"
    }, 
   {
    :id 4
    :first_name "Vale"
    :last_name "Culmer"
    :email "vculmer3@bloomberg.com"
    :gender "Female"
    :ip_address "56.96.150.226"
    }, 
   {
    :id 5
    :first_name "Pen"
    :last_name "Reymers"
    :email "preymers4@cargocollective.com"
    :gender "Female"
    :ip_address "77.49.201.208"
    }, 
   {
    :id 6
    :first_name "Yorke"
    :last_name "Greason"
    :email "ygreason5@xrea.com"
    :gender "Male"
    :ip_address "201.135.64.163"
    }, 
   {
    :id 7
    :first_name "Vickie"
    :last_name "Gullberg"
    :email "vgullberg6@loc.gov"
    :gender "Female"
    :ip_address "41.227.15.42"
    }, 
   {
    :id 8
    :first_name "Bird"
    :last_name "Chezier"
    :email "bchezier7@woothemes.com"
    :gender "Female"
    :ip_address "80.16.145.14"
    }, 
   {
    :id 9
    :first_name "Aleece"
    :last_name "Flucker"
    :email "aflucker8@google.cn"
    :gender "Female"
    :ip_address "46.241.196.180"
    }, 
   {
    :id 10
    :first_name "Costanza"
    :last_name "Alsford"
    :email "calsford9@pinterest.com"
    :gender "Female"
    :ip_address "203.63.200.33"
    }
   })
