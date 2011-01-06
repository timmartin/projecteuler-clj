(ns projecteuler-clj.test.question6
  (:use [projecteuler-clj.question6] :reload)
  (:use [clojure.test]))

(deftest test-sum-of-squares
  (is (= 385 (sum-of-squares 1 10)))
  (is (= 13 (sum-of-squares 2 3))))

(deftest test-square-of-sum
  (is (= 3025 (square-of-sum 1 10))))