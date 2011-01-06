(ns projecteuler-clj.question6
  (:use clojure.core))

(defn sum-of-squares
  [min max]
  (reduce
   +
   (map #(* % %) (range min (+ 1 max)))))

(defn square-of-sum
  [min max]
  (let [sum (reduce + (range min (+ 1 max)))]
	(* sum sum)))

(defn question6
  [min max]
  (- (square-of-sum min max)
	 (sum-of-squares min max)))