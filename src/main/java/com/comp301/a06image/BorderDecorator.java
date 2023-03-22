package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {
    private Image image;
    private int thiccness;
    private Color borderColor;
    public BorderDecorator(Image image, int thiccness, Color borderColor) {
        if (image == null || thiccness < 0) {
            throw new IllegalArgumentException();
        }
        this.image = image;
        this.thiccness = thiccness;
        this.borderColor = borderColor;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        //if coordinate is within border, return borderColor
        // else return image color
        return null;
    }

    @Override
    public int getWidth() {
        return image.getWidth() + thiccness * 2;
    }

    @Override
    public int getHeight() {
        return image.getHeight() + thiccness * 2;
    }

    @Override
    public int getNumLayers() {
        return image.getNumLayers() + 1;
    }
}
