(ns quil-sketches.sketch0002
  (:use [quil.core]))

;;; Now, let's just make the background a bit more colourful

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
  (frame-rate 1)
  (with-random-color background))

(defn draw []
  (stroke (random 255))
  (stroke-weight (random 10))
  (fill (random 255))

  (let [diam (random 100)
        x    (random (width))
        y    (random (height))]
    (ellipse x y diam diam)))

(defsketch example
  :title "Oh so many grey circles"
  :setup setup
  :draw draw
  :size [323 200])
