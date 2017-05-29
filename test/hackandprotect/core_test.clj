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

  (testing "execute"
    (is (= "aaabb" (execute add 1 3 2 "aaaaa")))
    (is (= "abbbb" (execute subtract 1 0 1 "bbbbb"))))
  )

