(ns projecteuler-clj.test.question1
  (:use [projecteuler-clj.question1] :reload)
  (:use [clojure.test]))

(deftest test-is-factor-of
  (is (is-factor-of 5 10))
  (is (is-factor-of 13 52))
  (is (not (is-factor-of 13 12)))
  (is (not (is-factor-of 12 13))))

(deftest test-sum-multiples-of
  (is (= 23
		 (sum-multiples-of 1 10 '(3 5)))))
