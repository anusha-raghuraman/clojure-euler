(ns euler.problem-7
  (:gen-class))

;; (last (take 10001 [X | X <- primes]))
(defn solve
    []
    (last (take 10001 (primes))))

(defn is-prime?
    [num]
    (let [sqrt (inc (Math/sqrt num))]
        (not (some #(= 0 (mod num %)) (range 2 sqrt)))))

(defn get-next-prime
    [start]
    (first (take 1 (filter is-prime? (iterate inc (inc start))))))

(defn primes
    ([] (primes 2))
    ([cur-prime]
     (let [next-prime (get-next-prime cur-prime)]
         (lazy-seq (cons cur-prime (primes next-prime))))))

