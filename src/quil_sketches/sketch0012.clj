(ns quil-sketches.sketch0012
  (:use [quil.core]))

;; Making the dot bigger, makes the big picture a bit coarser
;; Again, best viewed at maximum size

(defn colour-coll
  "Returns a vector with three random numbers between 0 and 255."
  []
  [(random 255) (random 255) (random 255)])

(defn with-random-color
  "Takes a functions f and calls it with three random parameters
between 0 and 255."
  [f]
  (apply f (colour-coll)))

(defn setup []
  (smooth)
  (frame-rate 30)
  (stroke-weight 3))

(defn percent-from-location [mid-n n]
  (- 1 (/ (float (abs (- mid-n n))) mid-n)))

(defn draw []
  (let [x (random (width))
        y (random (height))
        mid-x (/ (width) 2)
        mid-y (/ (height) 2)
        per-x (percent-from-location mid-x x)
        per-y (percent-from-location mid-y y)
        combined (/ (+ per-x per-y) 2)]
    (stroke (* 255 combined))
    (fill (* 255 (- 1 combined)))
    (ellipse x y 150 150)))

(defsketch example
  :title "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :size [323 200])
