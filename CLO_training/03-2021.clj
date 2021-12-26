(ns main
  (:require [clojure.java.io :as io]
            [utils :as tools]))

(def data_file "/home/elias/Good_repos/advents/2021/data_inputs/03-2021.txt")

(comment
  (Integer/parseInt (str 10110) 2)
  (frequencies (into [] (take 5 (repeat (vector 5)))))
  (Integer/toString 10110 8)
  )

 
(defn submarine-hexa
  [input-file]
  (let [data (->>
               (io/reader input-file)
               (line-seq))
         size (count data)
         vertical-bites (tools/make-nested-vec (count (first data)))
         i 0]
    (map #((for [e %
                 cpt (count vertical-bites)]
             (cond
               ))) data))) 
   

(submarine-hexa data_file)

(type (cons 2 [1 2 3 4]))

(tools/make-nested-vec 5 (Integer/toString 69 2))