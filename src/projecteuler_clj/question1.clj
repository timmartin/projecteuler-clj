(ns projecteuler-clj.question1)

(defn is-factor-of
  "Find whether one integer is a factor of another"
  [factor multiple]
  (= 0
	 (rem multiple factor)))

(defn sum-multiples-of
  "Add up the numbers between min (inclusive) and max (exclusive
that are multiples of one of the integers in factor-list"
  [min max factor-list]
  (if (< (- max 1) min)
	0
	(if (some (fn [x] (is-factor-of x (- max 1))) factor-list)
	  (+ (- max 1) (sum-multiples-of min (- max 1) factor-list))
	  (sum-multiples-of min (- max 1) factor-list))))

