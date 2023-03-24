package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {
  private final Image image;
  private final int multiplier;

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  public ZoomDecorator(Image image, int multiplier) {
    if (image == null || multiplier <= 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.multiplier = multiplier;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight()) {
      throw new IllegalArgumentException();
    } else {
      return image.getPixelColor(Math.round(x / multiplier), Math.round(y / multiplier));
    }
  }

  @Override
  public int getWidth() {
    return this.image.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return this.image.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return this.image.getNumLayers() + 1;
  }
}
