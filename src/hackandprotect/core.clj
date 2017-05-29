(ns hackandprotect.core
  (:require [hackandprotect.utils :refer :all]))

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

(defn encryption-step
  "Given operation, parameter, starting index, length and stream,
  execute the operation with the given parameter on the part of the stream
  from start for length chars."
  [op param start length stream]
  (map-in-str (partial op param) stream start length))

(def operations {
                 :add      add
                 :subtract subtract
                 :xor      xor
                 })

{
 :op-code  :add
 :op-param 5
 :length   5
 }