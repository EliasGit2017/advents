(ns main
  (:require [clojure.java.io :as io]))

(defn dec1
  [input-file]
  (with-open [digits (io/reader input-file)]
    (clojure.string/join "\n" (line-seq digits))))

(comment
 (println (dec1 "/home/elias2049/Good_Repo/advents_of_code/2020/data_inputs/01-2020.txt")))

(comment
 (println (slurp "/home/elias2049/Good_Repo/advents_of_code/2020/data_inputs/01-2020.txt"))
)

(defn the-elf-accountant
  [input-file]
  (with-open [input-txt (io/reader input-file)]
    (loop [digits (line-seq input-txt)]
      (if (not= )))))