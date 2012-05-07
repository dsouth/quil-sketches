(ns quil-sketches.sketch0008
  (:use [quil.core]))

;;; Location, location, location...

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

  (let [x (random (width))
        y (random (height))
        mid-x (/ (width) 2)
        mid-y (/ (height) 2)
        radius (random 100)
        d-width  (* radius (- 1 (/ (float (abs (- mid-x x))) mid-x)))
        d-height (* radius (- 1 (/ (float (abs (- mid-y y))) mid-y)))]
    (ellipse x y d-width d-height)))

(defsketch example
  :title "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :size [323 200])
