(ns clojure-voters.config
  (:require [cprop.core :refer [load-config]]
            [cprop.source :as source]
            [mount.core :refer [args defstate]]))

(defstate env
  :start
  (load-config
    :merge
    ;; will hold the cmd line args parsed in clojure_voters.core/start-app
    [(args)
     (source/from-system-props)
     (source/from-env)]))
