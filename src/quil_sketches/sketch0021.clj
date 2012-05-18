(ns quil-sketches.sketch0021
    (:use [quil.core]
          [quil-sketches.core])
    (:import (java.awt Image)
             (java.awt.image PixelGrabber)
             (java.io File)
             (javax.imageio ImageIO)))

;; Trying something a little different with colour...

(defn setup []
  (smooth)
  (frame-rate 60)
  (no-stroke)
  (let [file    (File. "clojure-logo10[1].png")
        img     (ImageIO/read file)
        width   (.getWidth img)
        height  (.getWidth img)
        grabber (PixelGrabber. img 0 0 width height true)]
    (.grabPixels grabber)
    (def img-width width)
    (def img-height height)
    (def x-dia (/ img-width 100))
    (def y-dia (/ img-height 100))
    (def pixel-vec (vec (.getPixels grabber)))))

(defn color-vec-from-int [x]
  [(red x) (green x) (blue x) (alpha x)])

(defn img-points []
  (for [x (range 0 img-width)
        y (range 0 img-height)]
    [x y]))

(defn draw-ellipse [x y x-dia y-dia]
  (ellipse x y x-dia y-dia))

(defn draw-rect [x-centre y-centre x-dia y-dia]
  (let [x (- x-centre (int (/ x-dia 2)))
        y (- y-centre (int (/ y-dia 2)))]
    (rect x y x-dia y-dia)))

(defn draw-shape [x y x-dia y-dia]
;  (draw-ellipse x y x-dia y-dia)
  (draw-rect x y x-dia y-dia)
  )

(defn make-point [[x y]]
  (let [color-index (int (+ (* y img-height) x))
        pixel-value (pixel-vec color-index)
        color-vec (color-vec-from-int pixel-value)]
    (apply fill color-vec)
    (draw-shape x y x-dia y-dia)))

(defn draw []
  (make-point [(int (random img-width)) (int (random img-height))]))

(start-sketch
 {:name "Oh so many colourful ellipses"
  :setup setup
  :draw draw
  :size [500 500]
  :filename "sketch0021.png"})
