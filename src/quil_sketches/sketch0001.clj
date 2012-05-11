(ns quil-sketches.sketch0001
  (:use [quil.core]
        [quil-sketches.core]))

;;; For reference purposes, this is the example from the quil README

(defn setup []
  (smooth)
  (frame-rate 1)
  (background 200))

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
  :filename "sketch0001.png"})
