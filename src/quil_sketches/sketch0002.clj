(ns quil-sketches.sketch0002
  (:use [quil.core]
        [quil-sketches.core]))

;;; Now, let's just make the background a bit more colourful

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

(start-sketch
 {:name "Oh so many grey circles"
  :setup setup
  :draw draw
  :filename "sketch0002.png"})
