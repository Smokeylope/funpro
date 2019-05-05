(ns v6s1.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn average
	[coll]
	(float(/ (reduce + coll) (count coll))))

(defn positiveAverage
	"Calculates positive averages from two lists."
	[tempsA tempsB]
	(average (filter nat-int? (concat [2 -2 4] [4 1 -3]))))

(def food-journal
  [{:kk 3 :paiva 1 :neste 5.3 :vesi 2.0}
   {:kk 3 :paiva 2 :neste 5.1 :vesi 3.0}
   {:kk 3 :paiva 13 :neste 4.9 :vesi 2.0}
   {:kk 4 :paiva 5 :neste 5.0 :vesi 2.0}
   {:kk 4 :paiva 10 :neste 4.2 :vesi 2.5}
   {:kk 4 :paiva 15 :neste 4.0 :vesi 2.8}
   {:kk 4 :paiva 29 :neste 3.7 :vesi 2.0}
   {:kk 4 :paiva 30 :neste 3.7 :vesi 1.0}])

(defn huhtikuu?
	[paiva]
	(= (get paiva :kk) 4))

(defn muuNeste
	[paiva]
	(- (get paiva :neste) (get paiva :vesi)))

(defn huhtikuuNeste
	[journal]
	(reduce + (map muuNeste (filter huhtikuu? journal))))

(defn muunna
	[paiva]
	(array-map :kk (get paiva :kk) :paiva (get paiva :paiva) :muuneste (- (get paiva :neste) (get paiva :vesi))))

(defn huhtikuuNesteMap
	[journal]
	(map muunna (filter huhtikuu? food-journal)))