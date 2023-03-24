package com.comp301.a06image;

import javafx.application.Application;

import java.awt.*;
import java.io.IOException;

public class Main {
  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    // TODO use this method for testing your decorators
    //    Color greenish = new Color(0, 255, 52);
    //    SolidColorImage solidColorImage = new SolidColorImage(200, 200, greenish);
    //    return solidColorImage;

    PictureImage img = new PictureImage("img/kmp.jpg");
    Color red = new Color(255, 0, 0);
    BorderDecorator redBorder = new BorderDecorator(img, 5, red);
    Color blue = new Color(0, 0, 255);
    BorderDecorator blueBorder = new BorderDecorator(redBorder, 50, blue);
    Color yellow = new Color(255, 255, 0);
    CircleDecorator circle = new CircleDecorator(blueBorder, 50, 50, 40, yellow);
    Color orange = new Color(200, 80, 10);
    SquareDecorator square = new SquareDecorator(circle, 100, 100, 40, orange);
    ZoomDecorator zoom = new ZoomDecorator(square);
    return zoom;

    //    PictureImage finalImg = new PictureImage("img/jedi.png");
    //    return finalImg;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   */
  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
