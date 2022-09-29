package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {
  private Image image;
  private int multipier;

  public ZoomDecorator(Image image, int multiplier) {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null");
    }
    if (multiplier < 1) {
      throw new IllegalArgumentException("Multiplier cannot be negative");
    }
    this.image = image;
    this.multipier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int resizedX = x / multipier;
    int resizedY = y / multipier;
    if (x < 0 || y < 0 || x >= this.getWidth() || y >= this.getHeight()) {
      throw new IllegalArgumentException("coordinates are invalid");
    }
    return image.getPixelColor(resizedX, resizedY);
  }

  @Override
  public int getWidth() {
    return image.getWidth() * multipier;
  }

  @Override
  public int getHeight() {
    return image.getHeight() * multipier;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
