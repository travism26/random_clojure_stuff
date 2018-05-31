(defproject clojureclass "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.4.474"]
                 [http-kit "2.3.0-beta2"]
                 [enlive "1.1.6"]]
  :plugins [[refactor-nrepl "2.3.1"]
            [cider/cider-nrepl "0.14.0"]]
  :main ^:skip-aot clojureclass.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

