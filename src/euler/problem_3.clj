(ns euler.problem-3
  (:gen-class))


;; (take 1 [X | X <- factors(600851475143), is_prime(X)]
(defn solve
    []
    (first (reverse (prime-factors 600851475143))))

(defn is-prime?
    [num]
    (let [sqrt (inc (Math/sqrt num))]
        (not (some #(= 0 (mod num %)) (range 2 sqrt)))))

;; [X | X <- (2 to sqrt(num), num % X == 0 and is-prime(X)]
(defn prime-factors
    [num]
    (filter is-prime?
            (for [x (range 2 (int (Math/sqrt num)))
                  :when (= 0 (mod num x))]
                x)))

