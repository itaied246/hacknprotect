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

(defn xor
  "Given a character and a number,
  xor the number with the ascii code of the character."
  [n c]
  (char (bit-xor n (int c))))

(def operations {
                 :add add
                 :subtract subtract
                 :xor xor
                 })

(defn execute
  [op param start length stream]
  (apply str (map (partial op param) stream)))

{
 :op-code :add
 :op-param 5
 :length 5
 }