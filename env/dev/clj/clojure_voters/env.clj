(ns clojure-voters.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [clojure-voters.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[clojure-voters started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[clojure-voters has shut down successfully]=-"))
   :middleware wrap-dev})
