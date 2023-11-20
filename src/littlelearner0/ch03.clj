(ns littlelearner0.ch03
  #_{:clj-kondo/ignore [:refer-all]}
  (:require [littlelearner0.matrixops :refer :all]
            [clojure.test :refer :all]))

(def line-xs [2.0 1.0 4.0 3.0])
(def line-ys [1.8 1.2 4.2 3.3])
(def teta [0.0 0.0])

(defn line
  [x]
  (fn [tt]
    (+ (* (first tt) x) (second tt))))

(is (= 7.3 ((line 7.3) [1.0 0.0])))

(defn shape
  [t]
  (cond
    (coll? t) (cons (count t) (shape (first t)))
    :else (list)))

(is (= '() (shape 9)))
(is (= '(6) (shape [9 8 7 6 0 1])))
(is (= '(2 3 1) (shape [[[5] [6] [8]] [[7] [9] [5]]])))

(defn ranked [t a]
  (cond
    (coll? t) (ranked (first t) (+ 1 a))
    :else a))

(defn rank
  "rank of a tensor is the length of its shape"
  [t]
  (ranked t 0))

(is (= 1 (rank [9])))
(is (= 3 (rank [[[8] [9]] [[4] [7]]])))


;; xxx same here
(defn sqr [x] (* x x))

(defn summed [t i a]
  (prn "summed" [t i a])
  (cond
    (zero? i) (+ (first t) a)
    :else (summed t (- i 1) (tns+ (nth t i) a))))

(defn sum [t]
  (prn "sum" [t])
  (summed t (- (count t) 1) 0.0))

(is (= 36.0 (sum [10.0 12.0 14.0])))
(is (= [[3 7] [11 5]] (sum [[[1 2] [3 4]] [[5 6] [7 8]]])))


(defn l2-loss
  "xxx"
  [target]
  (fn [xs ys]
    (fn [teta]
      (let [pred-ys ((target xs) teta)]
        (sum (sqr (- ys pred-ys)))))))


