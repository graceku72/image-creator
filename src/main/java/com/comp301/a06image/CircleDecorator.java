package com.comp301.a06image;

import java.awt.*;

import static java.lang.Math.sqrt;

public class CircleDecorator implements Image {
    private Image image;
    private int cx;
    private int cy;
    private int radius;
    private Color color;
    public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        this.image = image;
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (sqrt(Math.pow(cx - x, 2) + Math.pow(cy - y, 2)) < radius) {
            return color;
        }
        return image.getPixelColor(x, y);
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getNumLayers() {
        return image.getNumLayers() + 1;
    }
}
