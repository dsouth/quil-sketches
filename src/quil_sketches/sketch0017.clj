(ns quil-sketches.sketch0017
    (:use [quil.core]
          [quil-sketches.core]))

(def colors [[0.0 0.0 0.0]
             [256.0 256.0 256.0]
             [256.0 0.0 0.0]
             [0.0 256.0 0.0]
             [0.0 0.0 256.0]])

(def start-color (ref []))
(def current-color (ref []))
(def target-color (ref []))
(def my-point (ref []))

(defn get-target-color [colors]
  (let [i (rand-int (count colors))]
    (colors i)))

(defn setup []
  (smooth)
  (frame-rate 30)
  (stroke-weight 0)
  (dosync
   (ref-set target-color (get-target-color colors))
   (ref-set start-color [0.0 0.0 0.0])
   (ref-set current-color [0.0 0.0 0.0])
   (ref-set my-point [(/ (width) 2) (/ (height) 2)])))

(defn round-colour-coll [coll]
  (map #(java.lang.Math/round %) coll))

(defn next-color []
  (dosync
   (ref-set target-color (get-target-color colors))
   (ref-set start-color @current-color))
  (let [divisor 128
        delta (map #(/ (- % %2) divisor) @target-color @start-color)]
    (dosync
     (ref-set current-color (map + @current-color delta)))
    @current-color))

(defn random-jump []
  (- (random 50) 25.0))

(defn move [coll]
  (let [x (coll 0)
        y (coll 1)
        delta-x (random-jump)
        delta-y (random-jump)
        new-x (+ x delta-x)
        new-y (+ y delta-y)]
    [(if (< 0 new-x (width)) new-x
         (if (< new-x 0)
           (+ new-x (width))
           (- new-x (width))))
     (if (< 0 new-y (height)) new-y
         (if (< new-y 0)
           (+ new-y (height))
           (- new-y (height))))]))

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
  :filename "sketch0017.png"})
