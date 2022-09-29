package com.comp301.a06image;

// The pathname parameter represents the path of an image stored on your computer.
// You should be able to complete the implementation for the entire PictureImage class by
// encapsulating only one field, which stores a
// BufferedImage object. In the constructor, use the pathname parameter to create a BufferedImage
// object, and store it in a private field.
// A BufferedImage represents an image from your computer which has been read into memory. You can
// read more about it here.
// In particular, you'll have to use BufferedImage's getWidth(), getHeight(), and getRGB() methods
// to complete the PictureImage class.
// When you're done, test out your PictureImage class by making and returning an instance of
// PictureImage from the makeImage() static method
// located in the Main.java file. If you use "img/kmp.jpg" as the pathname argument, you should see
// a picture of kmp when running the main() method.

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {
  private final BufferedImage bufferedImage;

  public PictureImage(String pathname) throws IOException {
    this.bufferedImage = ImageIO.read(new File(pathname));
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int colorInt = this.bufferedImage.getRGB(x, y);
    return new Color(colorInt);
  }

  @Override
  public int getWidth() {
    return this.bufferedImage.getWidth();
  }

  @Override
  public int getHeight() {
    return this.bufferedImage.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1;
  }

  public int getRGB(int x, int y) {
    return this.bufferedImage.getRGB(x, y);
  }
}
