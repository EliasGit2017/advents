(ns main
  (:require [clojure.java.io :as io]))

(def data_file "/home/elias/Good_repos/advents/2021/data_inputs/03-2021.txt")

(comment
  (Integer/parseInt (str 10110) 2))

(defn submarine-hexa
  [input-file]
  (loop [data (->>
              (io/reader input-file)
              (line-seq))
         size (count data)
         line-size (count (first data))
         vertical-bites []
         i 0]
    (if (= i size)
      (do
        ()))))

(submarine-hexa data_file)
