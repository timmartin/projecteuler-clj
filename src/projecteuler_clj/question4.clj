(ns projecteuler-clj.question4
  (:use clojure.core))

; TODO Performance blows a little bit here. I suspect that it would be
; much better to be generating the list pre-ordered, rather than
; generating it and then applying a generalised sort algorithm. The
; only problem is that I can't see a straightforward way of producing
; the list in ordered form to start with.
(def products
	 (reverse
	  (sort
	   (for [x (range 100 999)
			 y (range x 999)]
		 (* x y)))))

(defn is-palindrome?
  "Figure out whether an integer is a decimal palindrome or not"
  [n]
  (= (seq (str n))
	 (reverse (str n))))

(defn question4
  []
  (first (filter is-palindrome? products)))