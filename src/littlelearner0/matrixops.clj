(ns littlelearner0.matrixops
  #_{:clj-kondo/ignore [:refer-all]}
  (:require [clojure.test :refer :all])
  (:require [clojure.tools.trace :refer :all]))

;; extended `+` and `*` operations defined in the book.
;; yet the book doesn't provide any implementations.

;; xxx check for matrix type in clojure
(defn tns+
  "need extended edition of + handling vectors; basically matrix addition"
  [x y]
  (prn "> " [x y])
  ;; (assert (vector? y) (format "second param must be a tensor! params were: %s" [x y]))
  (cond
    ;; both scalars
    (and (number? x) (number? y)) (+ x y)

    ;; If the first is a number and second is a list, add the number to each element of the list
    (number? x) (map (fn [elem]
                       (tns+ x elem))
                     y)
    ;; If the first is a list and the second is a number, add the number to each element of the list
    (number? y) (map (fn [elem]
                       (tns+ elem x))
                     x)

    ;; thanks chatgpt!
    (and (coll? x) (every? coll? y))
    (map (fn [nested-list] (tns+ x nested-list)) y)

    ;; If both are lists, add corresponding elements
    :else
    (map tns+ x y)))

(is (= [5 5] (tns+ [4 4] [1 1])))
(is (= [6 6] (tns+ 4 [2 2])))
(is (= [9] (tns+ [2] [7])))


;; In mathematics and tensor operations, adding two tensors of different
;; ranks is not typically defined. The rank of a tensor refers to the
;; number of dimensions in the tensor (e.g., a vector is a rank-1
;; tensor, a matrix is a rank-2 tensor, etc.) .
;; For tensors to be added together, they must have the same shape
;; and rank.
;; chatgpt did this!
(is (= [[10 12 9] [13 13 8]] (tns+ [6 9 1] [[4 3 8] [7 4 7]])))

;; ok now what:
(is (= [[5 8 9] [8 3 2]]
       (tns+ [[4 6 7] [2 0 1]] [[1 2 2] [6 3 1]])))

(defn tns*
  "need extended edition of * handling vectors; basically matrix addition"
  [x y] 0)
