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

(defn the-elf-accountant-1
  [input-file]
  (with-open [input-txt (io/reader input-file)]
    (let [numbers (map #(Integer/parseInt %) (into [] (line-seq input-txt)))
          size (count numbers)]
     (loop [i 0
            res []]
       (if (= i size)
         (* (first res) (last res))
         (recur (inc i)
                (loop [j 0
                       res res]
                  (if (or (= j size) (= (count res) 2))
                    res
                    (recur (inc j)
                           (if (and (not= i j) (= 2020 (+ (nth numbers i) (nth numbers j))))
                             (conj res (nth numbers i) (nth numbers j))
                             res))))))))))

(comment
 (println (type (nth (the-elf-accountant-1 data_file) 0))))
 

(the-elf-accountant-1 data_file)

(defn the-elf-accountant-2
  [input-file]
  (with-open [input-txt (io/reader input-file)]
    (let [numbers (map #(Integer/parseInt %) (into [] (line-seq input-txt)))
          size (count numbers)]
      (loop [i 0
             res []]
        (if (= i size)
          (reduce * res)
          (recur (inc i)
                 (loop [j 0
                        res res]
                   (if (or (= j size) (= (count res) 3))
                     res
                     (recur (inc j)
                            (loop [k 0
                                   res res]
                              (if (or (= k size) (= (count res) 3))
                                res
                                (recur (inc k)
                                       (if (and (not= i j k) (= 2020 (+ (nth numbers i) (nth numbers j) (nth numbers k))))
                                         (conj res (nth numbers i) (nth numbers j) (nth numbers k))
                                         res)))))))))))))

(the-elf-accountant-2 data_file)