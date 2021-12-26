(ns main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def data_file "/home/elias/Good_repos/advents/2021/data_inputs/02-2021.txt")

(defn submarine-control-1
  [input-file]
  (loop [data (->>
               (io/reader input-file)
               (line-seq))
         size (count data)
         x 0
         y 0
         i 0]
    (if (= i size)
      (* x y)
      (let [instruction (first (str/split (nth data i) #" "))
            level (Integer/parseInt (second (str/split (nth data i) #" ")))]
        (cond
          (= "forward" instruction) (recur data size (+ x level) y (inc i))
          (= "up" instruction) (recur data size x (- y level) (inc i))
          (= "down" instruction) (recur data size x (+ y level) (inc i)))))))

(submarine-control-1 data_file)

(defn submarine-control-2
  [input-file]
  (loop [data (->>
               (io/reader input-file)
               (line-seq))
         size (count data)
         x 0
         y 0
         aim 0
         i 0]
    (if (= i size)
      (* x y)
      (let [instruction (first (str/split (nth data i) #" "))
            level (Integer/parseInt (second (str/split (nth data i) #" ")))]
        (cond
          (= "forward" instruction) (recur data size (+ x level) (+ y (* aim level)) aim (inc i))
          (= "up" instruction) (recur data size x y (- aim level) (inc i))
          (= "down" instruction) (recur data size x y (+ aim level) (inc i)))))))

(submarine-control-2 data_file)