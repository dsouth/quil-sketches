(ns quil-sketches.core
  (:use [quil.core]))

(defn colour-coll
  "Returns a vector with three random numbers between 0 and 255."
  []
  [(random 255) (random 255) (random 255)])

(defn with-random-color
  "Takes a functions f and calls it with three random parameters
between 0 and 255."
  [f]
  (apply f (colour-coll)))

(defn start-sketch
  "Abstraction for adding extra functionality for sketches..."
  [sketch-map]
  (defsketch example
    :title (:name sketch-map)
    :setup (:setup sketch-map)
    :draw (:draw sketch-map)
    :mouse-clicked #(save (:filename sketch-map))
    :size [323 200]))
