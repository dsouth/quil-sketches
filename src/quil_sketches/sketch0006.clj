(ns quil-sketches.sketch0006
  (:use [quil.core]
        [quil-sketches.core]))

;;; Everyone, keep your arms inside the bus...

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
        x        (+ (random (- (width) d-width)) (/ d-width 2))
        y        (+ (random (- (height) d-height)) (/ d-height 2))]
    (ellipse x y d-width d-height)))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :filename "sketch0006.png"})
