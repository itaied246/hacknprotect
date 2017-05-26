(ns hackandprotect.core)

(defn add
  "Given a character and a number,
  add the number to the ascii code of the character."
  [n c]
  (char (+ n (int c))))

(defn subtract
  "Given a character and a number,
  subtract the number from the ascii code of the character."
  [n c]
  (add (- n) c))

(def operations {
                 :add add
                 :subtract subtract
                 })