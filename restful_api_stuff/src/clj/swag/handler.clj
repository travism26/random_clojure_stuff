(ns swag.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [swag.layout :refer [error-page]]
            [swag.routes.home :refer [home-routes]]
            [swag.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [swag.env :refer [defaults]]
            [mount.core :as mount]
            [swag.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
          #'service-routes
      (route/not-found
        (:body
          (error-page {:status 404
                       :title "page not found"}))))))
