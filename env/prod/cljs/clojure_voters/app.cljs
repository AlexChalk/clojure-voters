(ns clojure-voters.app
  (:require [clojure-voters.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
