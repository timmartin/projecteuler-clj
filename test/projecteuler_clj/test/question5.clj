(ns projecteuler-clj.test.question5
  (:use [projecteuler-clj.question5] :reload)
  (:use [clojure.test]))

(deftest test-power-factor
  (is (= 3 (power-factor 27 3)))
  (is (= 2 (power-factor 12 2))))

(deftest test-prime-factorisation
  (is (= {2 1
		  3 1
		  5 0
		  7 1
		  11 0
		  13 0
		  17 0
		  19 0}
		 (prime-factorisation 42 primes))))

(deftest test-combine-prime-factorisations
  (is (= {2 2, 3 1, 5 0, 7 0, 11 3, 13 0, 17 0, 19 0}
		 (combine-prime-factorisations
		  {2 1, 3 0, 5 0, 7 0, 11 3, 13 0, 17 0, 19 0}
		  {2 2, 3 1, 5 0, 7 0, 11 0, 13 0, 17 0, 19 0}))))