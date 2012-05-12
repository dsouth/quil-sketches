(ns quil-sketches.sketch0014
    (:use [quil.core]
          [quil-sketches.core]))

;; Smaller dots... takes longer to develop...
;; Again, best viewed at maximum size

(def start-color)
(def current-color)
(def target-color)

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

(defn target-reached? []
  (round-colour-coll @current-color))

(defn next-color []
  (when (target-reached?)
    (dosync
    (ref-set target-color (colour-coll))
    (ref-set start-color @current-color)))
  (let [jump-percent 10
        delta (map #(/ (- % %2) jump-percent) @target-color @start-color)]
    (dosync
     (ref-set current-color (map + @current-color delta)))
    @current-color))

(defn draw []
  (let [x (random (width))
        y (random (height))
        mid-x (/ (width) 2)
        mid-y (/ (height) 2)
        per-x (percent-from-location mid-x x)
        per-y (percent-from-location mid-y y)
        combined (/ (+ per-x per-y) 2)
        colour (next-color)]
    (apply fill colour)
    (ellipse x y 50 50)))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :filename "sketch0014.png"})
