package com.comp301.a06image;

import java.awt.*;

public class SolidColorImage implements Image {
  private final int width;
  private final int height;
  private final Color color;

  public SolidColorImage(int width, int height, Color color) {
    if (width < 0) {
      throw new IllegalArgumentException("Width cannot be less than 0");
    }
    if (height < 0) {
      throw new IllegalArgumentException("Height cannot be less than 0");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }
    this.width = width;
    this.height = height;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    // getPixelColor() should retrieve and return the color of the pixel at the specified (x, y)
    // location in the image.
    // Since this class represents a solid color image, all pixel values have the same color.
    // Therefore, getPixelColor() should return the same color for all pixel locations---that is,
    // the color encapsulated as a private field.
    // However, getPixelColor() should also check to make sure the specified coordinates are
    // actually within the boundaries of the image.
    // For example, if the provided x value is negative or if it is greater or equal to the width of
    // the image, then the coordinate is invalid.
    // If an invalid coordinate is detected, throw an IllegalArgumentException
    if (x < 0 | x >= this.width | y < 0 | y >= this.height) {
      throw new IllegalArgumentException("Coordinates are invalid");
    }
    return this.color;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
