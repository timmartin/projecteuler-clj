(ns projecteuler-clj.test.question4
  (:use [projecteuler-clj.question4] :reload)
  (:use [clojure.test]))

(deftest test-is-palindrome?
  (is (is-palindrome? 12321))
  (is (not (is-palindrome? 12323))))