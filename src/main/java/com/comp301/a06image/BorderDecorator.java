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
        if (x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight()) {
            throw new IllegalArgumentException();
        }
        if (x < this.getWidth() && x >= this.getWidth() - thiccness && y < this.getHeight() && y >= this.getHeight() - thiccness) {
            return borderColor;
        }
        Color imgColor = image.getPixelColor(x, y);
        return imgColor;
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
