package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {
  private final Image image;
  private final int squareX;
  private final int squareY;
  private final int squareSize;
  private final Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    // Constructor code goes here
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null");
    }
    if (squareSize < 0) {
      throw new IllegalArgumentException("squareSize cannot be negative");
    }
    this.image = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0) {
      throw new IllegalArgumentException("cannot be 0");
    }
    if (y < 0) {
      throw new IllegalArgumentException("cannot be 0");
    }
    if (x >= getWidth() | y >= getHeight()) {
      throw new IllegalArgumentException("greater than width and height");
    }

    if (x < squareX || y < squareY | x >= squareX + squareSize | y >= squareY + squareSize) {
      // code here for when the point is out of the bounds
      return image.getPixelColor(x, y);
    } else {
      // code here for when the point is within the bounds
      return color;
    }
    // return null;
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
