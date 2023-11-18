(ns littlelearner0.matrixops-test
  (:require [clojure.test :refer :all]
            [littlelearner0.matrixops :refer :all]))

(deftest mtx+-test
  (testing "tensor addition"
    (is (= [5 5] (tns+ [4 4] [1 1])))
    (is (= [6 6] (tns+ 4 [2 2])))
    (is (= [9] (tns+ [2] [7])))

    ;; In mathematics and tensor operations, adding two tensors of different
    ;; ranks is not typically defined. The rank of a tensor refers to the
    ;; number of dimensions in the tensor (e.g., a vector is a rank-1
    ;; tensor, a matrix is a rank-2 tensor, etc.) .
    ;; For tensors to be added together, they must have the same shape
    ;; and rank.
    ;; (is (= [[10 12 9] [13 13 8]] (tns+ [6 9 1] [[4 3 8] [7 4 7]])))
    (is (= [[5 8 9] [8 3 2]]
           (tns+ [[4 6 7] [2 0 1]] [[1 2 2] [6 3 1]])))))
