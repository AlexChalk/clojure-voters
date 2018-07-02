(ns clojure-voters.handler
  (:require 
            [clojure-voters.layout :refer [error-page]]
            [clojure-voters.routes.home :refer [home-routes]]
            [clojure-voters.routes.services :refer [service-routes]]
            [compojure.core :refer [routes wrap-routes]]
            [ring.util.http-response :as response]
            [clojure-voters.middleware :as middleware]
            [compojure.route :as route]
            [clojure-voters.env :refer [defaults]]
            [mount.core :as mount]))

(mount/defstate init-app
  ;; init-app is defined as the identity function if defaults has no
  ;; init key
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

