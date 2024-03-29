(ns quil-sketches.sketch0015
    (:use [quil.core]
          [quil-sketches.core]))

(def start-color (ref []))
(def current-color (ref []))
(def target-color (ref []))
(def my-point (ref []))

(defn setup []
  (smooth)
  (frame-rate 30)
  (stroke-weight 0)
  (dosync
   (ref-set target-color (colour-coll))
   (ref-set start-color [0.0 0.0 0.0])
   (ref-set current-color [0.0 0.0 0.0])
   (ref-set my-point [(/ (width) 2) (/ (height) 2)])))

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

(defn random-jump []
  (- (random 50) 25))

(defn move [coll]
  (let [x (coll 0)
        y (coll 1)
        delta-x (random-jump)
        delta-y (random-jump)
        new-x (+ x delta-x)
        new-y (+ y delta-y)]
    [(if (< 0 new-x (width)) new-x x)
     (if (< 0 new-y (height)) new-y y)]))

(defn update-my-point []
  (dosync
   (alter my-point move)))

(defn draw []
  (let [x (@my-point 0)
        y (@my-point 1)
        dia (min (width) (height))
        colour (next-color)]
    (apply fill colour)
    (ellipse x y 50 50))
  (update-my-point))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :size [750 750]
  :filename "sketch0015.png"})
