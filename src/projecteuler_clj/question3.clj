(ns projecteuler-clj.question3
  (:use clojure.core))

(defn divisible-by
  [x y]
  (= 0 (rem x y)))

(defn next-prime
  "Find the next prime after min, where known-primes is assumed to be a list of
all primes less than min"
  [known-primes min]
  (if (not-any? (fn [x] (divisible-by min x)) known-primes)
	min
	(next-prime known-primes (+ min 1))))

(defn lazy-primes
  ([] (lazy-primes [] 2))
  ([known-primes min]
	 (lazy-seq
	  (let [p (next-prime known-primes min)]
		(cons p (lazy-primes (list* p known-primes) (+ p 1)))))))

(defn candidate-prime-factors
  "Return a lazy seq of primes that could be factors of the specified integer,
based on a simple range calculation"
  [n]
  (take-while (fn [x] (<= x n)) (lazy-primes)))

(defn prime-factors
  "Return a lazy seq of prime factors of the specified integer"
  [n]
  (filter (fn [x] (divisible-by n x)) (candidate-prime-factors n)))

(defn eliminate-factors
  "Return an integer that is the result of dividing out any factors of p from n"
  [p n]
  (if (divisible-by n p)
	(eliminate-factors p (/ n p))
	n))

(defn largest-prime-factor
  "Find the largest prime factor of n, which must be an integer greater than 1"
  [n]
  (let [factors (prime-factors n)
		p (first factors)
		reduced (eliminate-factors p n)]
	(if (= 1 reduced)
	  p
	  (max p (largest-prime-factor reduced)))))