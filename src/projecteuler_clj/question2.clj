(ns projecteuler-clj.question2
  (:use clojure.core))

(defn lazy-seq-fibo
  "Fibonacci numbers as a lazy seq, taken from Programming Clojure
by Stuart Halloway"
  ([]
	 (concat [0 1] (lazy-seq-fibo 0 1)))
  ([a b]
	 (let [n (+ a b)]
	   (lazy-seq
		(cons n (lazy-seq-fibo b n))))))

(defn even
  [x]
  (= 0 (rem x 2)))

(defn question2
  "Find the sum of even terms in the Fibonacci sequence that do not exceed
four million"
  []
  (reduce +
		  (filter even
				  (take-while (fn [x] (< x 4000000))
							  (lazy-seq-fibo)))))