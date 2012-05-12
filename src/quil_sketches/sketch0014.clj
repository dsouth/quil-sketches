(ns quil-sketches.sketch0014
    (:use [quil.core]
          [quil-sketches.core]))

;; Trying something a little different with colour...

(def start-color (ref []))
(def current-color (ref []))
(def target-color (ref []))

(defn setup []
  (smooth)
  (frame-rate 30)
  (stroke-weight 0)
  (dosync
   (ref-set target-color (colour-coll))
   (ref-set start-color [0.0 0.0 0.0])
   (ref-set current-color [0.0 0.0 0.0])))

(defn round-colour-coll [coll]
  (map #(java.lang.Math/round %) coll))

(defn next-color []
  (dosync
   (ref-set target-color (colour-coll))
   (ref-set start-color @current-color))
  (let [jump-percent 10
        delta (map #(/ (- % %2) jump-percent) @target-color @start-color)]
    (dosync
     (ref-set current-color (map + @current-color delta)))
    @current-color))

(defn draw []
  (let [x (random (width))
        y (random (height))
        colour (next-color)]
    (apply fill colour)
    (ellipse x y 50 50)))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :filename "sketch0014.png"})
