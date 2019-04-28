(ns v5s1.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn square
	"Returns the square of n."
	[n]
	(* n n))

(defn karkausvuosi?
	"Palauttaa true jos vuosi on karkausvuosi."
	[vuosi]
	(cond (zero? (mod vuosi 400)) true
              (zero? (mod vuosi 100)) false
              (zero? (mod vuosi 4)) true
              :default false))