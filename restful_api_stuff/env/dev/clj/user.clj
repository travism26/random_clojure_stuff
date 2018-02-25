(ns user
  (:require 
            [mount.core :as mount]
            [swag.core :refer [start-app]]))

(defn start []
  (mount/start-without #'swag.core/repl-server))

(defn stop []
  (mount/stop-except #'swag.core/repl-server))

(defn restart []
  (stop)
  (start))


