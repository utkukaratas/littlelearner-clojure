(ns littlelearner0.matrixops)

;; xxx check for matrix type in clojure
(defn tns+
  "need extended edition of + handling vectors; basically matrix addition"
  [x y]
  ;; (prn "> " [x y])
  ;; (assert (vector? y) (format "second param must be a tensor! params were: %s" [x y]))
  (if (and (number? x) (number? y))
    ;; both scalars
    (+ x y)

    (if (number? x)
      ;; x is a scalar
      (map (fn [elem]
             (if (vector? elem)
               (tns+ x elem)
               (+ x elem)))
           y)

      ;; x is a tensor
      (map (fn [elem1 elem2]
             (if (vector? elem1)
               (tns+ elem1 elem2)
               (+ elem1 elem2)))
           x y))))

(defn tns*
  "need extended edition of * handling vectors; basically matrix addition"
  [x y] 0)
