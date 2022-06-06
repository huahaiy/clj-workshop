(ns clj-workshop.core)

;; IMPORTANT: REPL driven development
;; 1. Connect editor to a REPL (jack-in)
;; 2. Write code in editor, send form to REPL to evaluate
;; 3. Start from small functions, build from bottom up
;; 4. Copy test code to test file, or leave them in comment

(defn hello-world
  "Say the first words"
  [x]
  (println x "Hello, World!"))

(hello-word "John")

;; unit of evaluation: form

;; IMPORTANT: data oriented programming: program with data literals

:a-keyword

:ns/a-keyword

42

"a string"

'a-symbol

true

false

nil

["this is a" :vector]

'("this is a" :list)

{:a-key      "value"
 :anther-key "value"}

#{"I" "am" "a" :set}

{:a-vector-value [1 2 4 #{"nesting" "is" "powerful"}]
 1               [{:name "data"}]}

;; IMPORTANT: functional programming. Functions are the building block

;; Everything is an expression, i.e. return something

(+ 1 2 3 4 5)

(println "a")

(defn sum-2-fn
  "two arity sum"
  [a b]
  (+ a b))

(defn print-2-fn-result
  [f a b]
  (with-out-str
    (println {:function f
              :result   (f a b)})))

(print-2-fn-result sum-2-fn 1 2)

;; def bind a value to a symbol

(def a-fn (fn [p1 p2] (str p1 "-" p2)))

(a-fn 'a "b")

(def a-map {:a 1 :b 2})

;; IMPORTANT: data are immutable

(assoc a-map :c 3)
(dissoc a-map :a)

a-map

;; many things can be used as a function
(a-map :a)
(:a a-map)
([1 2 3] 1)
(#{:a :b :c} :c)

;; Control structures

(let [x 42
      y 1]
  (+ x (inc y)))

(if (< 1 2 3)
  "good"
  :impossible)

(when (and (< 1 2 3) (> 4 3 2 1))
  "good")

(let [x 5]
  (cond
    (< x 0)   :negative
    (zero? x) :zero
    :else     :positive))

;; Everything, except nil and false, are truthy

(nil? "")
(nil? 0)
(nil? [])

(def xs [1 2 3 4 5])

;; check empty with seq
(seq xs)
(seq [])
(seq {})

(when (seq xs) :empty)

;; IMPORTANT: remember core functions, particularly sequence functions
;; https://clojure.org/reference/sequences

(first xs)
(rest xs)
(cons 0 xs)
(conj xs 6)

;; When you need a loop, for your readers to get your intention immediately,
;; follow this order:

;; 1. first try one of the core functions

(map inc xs)

(filter even? xs)
(remove even? xs)

(take 2 xs)
(drop 2 xs)

(reverse xs)

;; 2. try reduce, it is universal

(reduce (fn [acc x]
          (str acc "-" x))
        [1 2 3 4])

(reduce + [1 2 3 4])
(reduce + 0 [1 2 3 4])

;; 3, if the above fail, try loop-recur as last resort

(loop [xs     [1 2 3 4 5]
       result []]
  (if xs
    (let [x (first xs)]
      (recur (next xs) (conj result (* x x))))
    result))

(comment

  )
