(ns clojure-voters.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [clojure-voters.core-test]))

(doo-tests 'clojure-voters.core-test)

