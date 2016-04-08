(ns euler.problem-1
  (:gen-class))

(defn sum-of-multiples
    []
    (let [is-multiple-of-3 (fn[x] (= 0 (mod x 3)))
          is-multiple-of-5 (fn[x] (= 0 (mod x 5)))
          is-multiple-of-3-or-5 (fn[x] (or (is-multiple-of-3 x) (is-multiple-of-5 x)))]

        (apply + (filter is-multiple-of-3-or-5 (range 1 1000)))))

