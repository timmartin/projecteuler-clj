(ns projecteuler-clj.test.question3
  (:use [projecteuler-clj.question3] :reload)
  (:use [clojure.test]))

(deftest test-divisible-by
  (is (divisible-by 36 12))
  (is (divisible-by 81 9))
  (is (divisible-by 91 13))
  (is (not (divisible-by 91 4))))

(deftest test-next-prime
  (is (= 3 (next-prime [2] 3)))
  (is (= 5 (next-prime [2 3] 5)))
  (is (= 5 (next-prime [2 3] 4)))
  (is (= 13 (next-prime [2 3 5 7 11] 12))))

(deftest test-candidate-prime-factors
  (is (= (list 2 3 5 7 11) (candidate-prime-factors 12)))
  (is (= (list 2 3 5 7 11 13 17 19) (candidate-prime-factors 20))))

(deftest test-prime-factors
  (is (= (list 2 3) (prime-factors 6)))
  (is (= (list 3 5 7) (prime-factors (* 3 5 7 7)))))

(deftest test-largest-prime-factor
  (is (= 3 (largest-prime-factor 12)))
  (is (= 7 (largest-prime-factor 7)))
  (is (= 5 (largest-prime-factor 100))))