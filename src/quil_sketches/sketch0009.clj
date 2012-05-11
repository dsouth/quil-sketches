(ns quil-sketches.sketch0009
    (:use [quil.core]
          [quil-sketches.core]))

;;; Back to classic black and white

(defn setup []
  (smooth)
  (frame-rate 30)
  (stroke-weight 3))

(defn percent-from-location [mid-n n]
  (- 1 (/ (float (abs (- mid-n n))) mid-n)))

(defn draw []
  (let [x (random (width))
        y (random (height))
        diam (/ (max (width) (height)) 10)
        mid-x (/ (width) 2)
        mid-y (/ (height) 2)
        per-x (percent-from-location mid-x x)
        per-y (percent-from-location mid-y y)
        combined (/ (+ per-x per-y) 2)]
    (stroke (* 255 combined))
    (fill (* 255 (- 1 combined)))
    (ellipse x y diam diam)))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :filename "sketch0009.png"})
