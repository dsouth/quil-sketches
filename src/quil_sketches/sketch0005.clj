(ns quil-sketches.sketch0005
  (:use [quil.core]))

;;; Circles are so yesterday...

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
  (with-random-color background))

(defn draw []
  (with-random-color stroke)
  (stroke-weight (random 10))
  (with-random-color fill)

  (let [d-width  (random 100)
        d-height (random 100)
        x        (random (width))
        y        (random (height))]
    (ellipse x y d-width d-height)))

(defsketch example
  :title "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :size [323 200])
