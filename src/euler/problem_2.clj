(ns euler.problem-2
  (:gen-class))

(defn get-next-fib
    [prev-one prev-two]
    (+ prev-one prev-two))

(defn fib [a b] (lazy-seq (cons a (fib b (+ b a)))))


;; (sum [X | X <- fibs, X <= 4_000_000, X % 2 == 0])
(defn solve
    []
    (apply + (filter #(= 0 (mod % 2)) (take-while #(<= % (* 4 1000 1000)) (fib 1 2)))))

