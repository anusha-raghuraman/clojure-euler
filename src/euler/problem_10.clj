(ns euler.problem-10
  (:gen-class))

;; (sum [X | X <- (primes), X < 2_000_000])
(defn solve
    []
    (apply + (take-while #(< % (* 2 1000 1000)) (primes))))

(defn primes
    ([] (primes 2))
    ([cur-prime]
     (let [next-prime (get-next-prime cur-prime)]
         (lazy-seq (cons cur-prime (primes next-prime))))))

(defn get-next-prime
    [start]
    (first (take 1 (filter is-prime? (iterate inc (inc start))))))

(defn is-prime?
    [num]
    (let [sqrt (inc (Math/sqrt num))]
        (not (some #(= 0 (mod num %)) (range 2 sqrt)))))
