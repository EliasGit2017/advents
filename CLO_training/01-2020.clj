(ns main
  (:require [clojure.java.io :as io]
             [clojure.string :as string]))

(def data_file "/home/elias/Good_repos/advents/2020/data_inputs/01-2020.txt")

(defn dec1
  [input-file]
  (with-open [digits (io/reader input-file)]
    (string/join "\n" (line-seq digits))))

(comment
 (println (dec1 "/home/elias2049/Good_Repo/advents_of_code/2020/data_inputs/01-2020.txt")))

;;  (println (slurp "/home/elias/Good_repos/advents/2020/data_inputs/01-2020.txt"))


(defn the-elf-accountant
  [input-file]
  (with-open [input-txt (io/reader input-file)]
    (loop [numbers (map #(Integer/parseInt %) (into [] (line-seq input-txt)))
          size (count numbers)
          i 0
          res []]
      if (= i (- size 1))
      (loop [numbers2 (map #(Integer/parseInt %) (into [] (line-seq input-txt)))
             i2 0]
        if (= i (- size 1))
        ))))

(println (type (nth (the-elf-accountant data_file ) 0)))

(println (the-elf-accountant data_file))