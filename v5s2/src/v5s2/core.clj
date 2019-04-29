(ns v5s2.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn even
	[]
	(println "Give a number: ")
	(let [n (Integer/parseInt (read-line))]
		(if (> n 0)
			(println(zero?(mod n 2)))
			(do
				(println "Error: Value must be greater than 0!")
				(recur)))))

(defn divisibleByThree
	[max]
	(loop [i 1]
		(if (zero? (mod i 3))
			(println i))
		(if (< i max)
			(recur(inc i)))))

(defn lotto
	[]
	(let [numbers #{}]
		(loop [n #{}]
			(if (>= (count n) 7)
				(println n)
				(recur(conj n (+ (rand-int 39) 1)))))))
