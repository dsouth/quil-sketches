(ns quil-sketches.sketch0010
    (:use [quil.core]
          [quil-sketches.core]))

;;; Now in black and blue...

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
    (stroke 0 0 (* 255 combined))
    (fill 0 0 (* 255 (- 1 combined)))
    (ellipse x y diam diam)))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :filename "sketch0010.png"})
