package model;

import model.interfaces.IShape;

import java.awt.*;

public class OutlineDecorator {

  private OutlineDrawer outlineDrawer;

  void draw(IShape shape) {
    outlineDrawer = new OutlineDrawer();
    outlineDrawer.draw(shape);
  }

}
