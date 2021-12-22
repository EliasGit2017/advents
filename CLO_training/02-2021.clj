(ns main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def data_file "/home/elias/Good_repos/advents/2021/data_inputs/02-2021.txt")

(defn submarine-control
 [input-file]
  (loop [data (->>
          (io/reader input-file)
          (line-seq))
         x 0
         y 0
         size (count data)
         i 0]
    (if (= i size)
      (* x y)
      (cond
        (= "forward" (first (str/split (nth data i) #" "))) (recur data (+ x (Integer/parseInt (second (str/split (nth data i) #" ")))) y size (inc i))
        (= "up" (first (str/split (nth data i) #" "))) (recur data x (- y (Integer/parseInt (second (str/split (nth data i) #" ")))) size (inc i))
        (= "down" (first (str/split (nth data i) #" "))) (recur data x (+ y (Integer/parseInt (second (str/split (nth data i) #" ")))) size (inc i))))))

(submarine-control data_file)