(ns quil-sketches.sketch0003
  (:use [quil.core]
))

;;; Random colour EVERYWHERE! :)

(defn setup []
  (smooth)
  (frame-rate 1)
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
 {:name "Oh so many grey circles"
  :setup setup
  :draw draw
  :filename "sketch0003.png"})
