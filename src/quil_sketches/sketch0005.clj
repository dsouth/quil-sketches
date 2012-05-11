(ns quil-sketches.sketch0005
  (:use [quil.core]
        [quil-sketches.core]))

;;; Circles are so yesterday...

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

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :filename "sketch0005.png"})
