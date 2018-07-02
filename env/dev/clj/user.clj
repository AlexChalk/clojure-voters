(ns user
  (:require [clojure-voters.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [clojure-voters.figwheel :refer [start-fw stop-fw cljs]]
            [clojure-voters.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'clojure-voters.core/repl-server))

(defn stop []
  (mount/stop-except #'clojure-voters.core/repl-server))

(defn restart []
  (stop)
  (start))


