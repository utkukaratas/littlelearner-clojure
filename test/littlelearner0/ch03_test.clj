(ns littlelearner0.ch03-test
  (:require [clojure.test :refer :all]
            [littlelearner0.ch03 :refer :all]))

(deftest ch03-test
  (testing "ch03"
    (is (= 7.3 ((line 7.3) [1.0 0.0])))
    (is (= '() (shape 9)))
    (is (= '(6) (shape [9 8 7 6 0 1])))
    (is (= '(2 3 1) (shape [[[5] [6] [8]] [[7] [9] [5]]])))
    (is (= 1 (rank [9])))
    (is (= 3 (rank [[[8] [9]] [[4] [7]]])))
    (is (= 36.0 (sum [10.0 12.0 14.0])))
    ))
