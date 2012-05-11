(ns quil-sketches.sketch0004
  (:use [quil.core]
        [quil-sketches.core]))

;;; Time to speed things up a bit...

(defn setup []
  (smooth)
  (frame-rate 30)
  (with-random-color background))

(defn draw []
  (with-random-color stroke)
  (stroke-weight (random 10))
  (with-random-color fill)

  (let [diam (random 100)
        x    (random (width))
        y    (random (height))]
    (ellipse x y diam diam)))

(start-sketch
 {:name "Oh so many colourful circles"
  :setup setup
  :draw draw
  :filename "sketch0004.png"})
