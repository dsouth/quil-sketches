(ns quil-sketches.sketch0007
  (:use [quil.core]
        [quil-sketches.core]))

;;; Location, location, location...

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
        d-width  (* radius (/ (float (abs (- mid-x x))) mid-x))
        d-height (* radius (/ (float (abs (- mid-y y))) mid-y))]
    (ellipse x y d-width d-height)))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :filename "sketch0007.png"})
