(ns hackandprotect.core-test
  (:require [clojure.test :refer :all]
            [hackandprotect.core :refer :all]))

(deftest test
  (testing "add"
    (testing "with upper case letters"
      (is (= \B (add 1 \A)))
      (is (= \A (add 0 \A))))

    (testing "with lower case letters"
      (is (= \b (add 1 \a)))
      (is (= \a (add 0 \a)))))

  (testing "subtract"
    (testing "with upper case letters"
      (is (= \A (subtract 1 \B)))
      (is (= \A (subtract 0 \A))))

    (testing "with lower case letters"
      (is (= \a (subtract 1 \b)))
      (is (= \a (subtract 0 \a)))))

  (testing "xor"
    (testing "with upper case letters"
      (is (= \@ (xor 1 \A)))
      (is (= \A (xor 0 \A))))

    (testing "with lower case letters"
      (is (= \` (xor 1 \a)))
      (is (= \a (xor 0 \a)))))

  (testing "encryption-step"
    (is (= "aaabb" (encryption-step add 1 3 2 "aaaaa")))
    (is (= "abbbb" (encryption-step subtract 1 0 1 "bbbbb"))))

  (testing "encryption-step overlapping"
    (is (= "c" (encryption-step add 1 0 2 "a")))
    (is (= "ac" (encryption-step add 1 1 2 "aa")))
    (is (= "ddd" (encryption-step add 1 0 9 "aaa"))))

  (testing "encrypt"
    (is (= "bbcccc" (encrypt [{:op-code  :add
                               :op-param 1
                               :length   2}
                              {
                               :op-code  :add
                               :op-param 2
                               :length   4
                               }]
                             "aaaaaa")))
    (is (= "bbeeee" (encrypt [{:op-code  :add
                               :op-param 1
                               :length   2}
                              {
                               :op-code  :add
                               :op-param 2
                               :length   8
                               }]
                             "aaaaaa"))))

  (testing "decrypt"
    (is (= "ccccccc" (decrypt [{:op-code  :add
                               :op-param 1
                               :length   4}
                              {:op-code   :subtract
                               :op-param 2
                               :length   3}]
                             "ddddaaa"))))
  )

