(ns hackandprotect.utils-test
  (:require [clojure.test :refer :all]
            [hackandprotect.utils :refer :all]
            [hackandprotect.core :refer :all]))

(deftest utils

  (testing "map-in-str"
    (is (= "bbbaa" (map-in-str (partial add 1)
                               "aaaaa"
                               0
                               3)))
    (is (= "abbba" (map-in-str (partial add 1)
                               "aaaaa"
                               1
                               3)))
    (is (= "aabbb" (map-in-str (partial add 1)
                               "aaaaa"
                               2
                               3))))
  )


