(ns hackandprotect.core
  (:require [hackandprotect.utils :refer :all])
  (:require [clojure.string :as str]))

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
  (let [applied-op (partial op param)
        valid-length (min length (- (count stream) start))
        applied-stream (map-in-str applied-op stream start valid-length)]
    (if (> length valid-length)
      (str/reverse (encryption-step op param 0 (- length valid-length) (str/reverse applied-stream)))
      applied-stream)))

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