(ns hackandprotect.core-test
  (:require [clojure.test :refer :all]
            [hackandprotect.core :refer :all]))

(deftest test
  (testing "add"
    (testing "with capital letters"
      (is (= \B (add 1 \A)))
      (is (= \A (add 0 \A))))

    (testing "with lower case letters"
      (is (= \b (add 1 \a)))
      (is (= \a (add 0 \a)))))

  (testing "subtract"
    (testing "with capital letters"
      (is (= \A (subtract 1 \B)))
      (is (= \A (subtract 0 \A))))

    (testing "with lower case letters"
      (is (= \a (subtract 1 \b)))
      (is (= \a (subtract 0 \a))))))

