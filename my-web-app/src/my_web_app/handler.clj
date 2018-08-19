(ns my-web-app.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/testing" {:keys [uri]}
       (format "requested: %s" uri))
  (GET "/" [] "Hello World!")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
