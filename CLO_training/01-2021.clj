(ns main
  (:require [clojure.java.io :as io]))

(def data_file "/home/elias/Good_repos/advents/2021/data_inputs/01-2021.txt")

(defn submarine-1
  [input-file]
  (with-open [input-txt (io/reader input-file)]
    (let [numbers (map #(Integer/parseInt %) (into [] (line-seq input-txt)))
          size (count numbers)]
      (comment (println numbers))
      (loop [i 2
             res (if (< (nth numbers 0) (nth numbers (dec i)))
                   1
                   0)]
        (if (= i size)
          res
          (recur (inc i)
                 (if (< (nth numbers (dec i)) (nth numbers i))
                  (inc res)
                  res)))))))

(submarine-1 data_file)

(defn vec-split-at [idx v]
  [(subvec v 0 idx) (subvec v idx)])

(defn submarine-2
  [input-file]
  (with-open [input-txt (io/reader input-file)]
    (let [setsof3 (vec (map #(into [] %) (partition 3 1 nil (map #(Integer/parseInt %) (into [] (line-seq input-txt))))))
          size (count setsof3)]
      (loop [i 2
             res (if (< (reduce + (nth setsof3 0)) (reduce + (nth setsof3 1)))
                   1
                   0)]
        (if (= i size)
          res
          (recur (inc i)
                 (if (< (reduce + (nth setsof3 (dec i))) (reduce + (nth setsof3 i)))
                   (inc res)
                   res)))))))

(submarine-2 data_file)