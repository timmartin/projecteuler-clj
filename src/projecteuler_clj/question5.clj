(ns projecteuler-clj.question5
  (:use clojure.core))

(def primes [2 3 5 7 11 13 17 19])

(defn power-factor
  "Get the power with which the specified prime factor divides the number n"
  [n p]
  (if (= 0 (rem n p))
	(+ 1 (power-factor (/ n p) p))
	0))

(defn prime-factorisation
  "Get the prime factorisation of a number n, as a map with primes as the keys"
  [n remaining-primes]
  (let [p (first remaining-primes)
		next (rest remaining-primes)]
	(if (empty? next)
	  {p (power-factor n p)}
	  (assoc (prime-factorisation n next)
		p (power-factor n p)))))

(defn number-from-prime-factorisation
  [factorisation]
  (reduce *
		  (map (fn [thing] (int (. Math pow (first thing) (first (rest thing)))))
			   factorisation)))

(defn combine-prime-factorisations
  "Given two prime factorisations, find the smallest prime factorisation that is
divisible by both. That is, for each prime factor we take the final power to be
the max of the powers of the same factor in the two input factorisations"
  [& args]
  (apply merge-with max args))

(defn question5
  []
  (number-from-prime-factorisation
   (reduce combine-prime-factorisations
		   (map #(prime-factorisation % primes) (range 1 20)))))