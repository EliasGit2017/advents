(ns utils
  (:use midje.sweet)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.java.shell :as sh]))

(defn make-nested-vec
  "Creates `size` vectors containing `content` (if specified)"
  ([size] (into [] (take size (repeat (vector)))))
  ([size content] (into [] (take size (repeat (vector content))))))

(facts
 (make-nested-vec 5 0) => [[0] [0] [0] [0] [0]]
 (make-nested-vec 0) => []
 (make-nested-vec 0 5) => []
 )

(sh/with-sh-dir "/home/elias/Good_repos"
                (comment 
                  (println ((sh/sh "zsh" "-c" "ls -l") :out))
                  )
                ((sh/sh "zsh" "-c" "ls -l") :out))

(sh/sh "zsh" "-c" "ls ~/")
(println (sh/sh "zsh" "-c" "ls ~/"))
(str/trim "      \t          babanzda354 deasv! !ù*!*  adac \t\t")