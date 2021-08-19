package model;

import model.interfaces.IShape;

import java.util.Stack;

/**
 * This is not precise detection because I tried to treat all shapes as single type (rectangle in
 * this case), probably will replace it with better algorithm later.
 * <p>
 * Algorithm to detect two rectangle collision from stackoverflow below
 * https://stackoverflow.com/questions/31022269/collision-detection-between-two-rectangles-in-java
 * bool isIntersect( int Ax, int Ay, int Aw, int Ah, int Bx, int By, int Bw, int Bh) { return Bx +
 * Bw > Ax && By + Bh > Ay && Ax + Aw > Bx && Ay + Ah > By; }
 */
public class CollisionDetection {

  ShapeList shapeList;
  TwoPoint twoPoint;

  public CollisionDetection(ShapeList shapeList, TwoPoint twoPoint) {
    this.shapeList = shapeList;
    this.twoPoint = twoPoint;
  }

  public void addSelectShape() {
    int Ax = twoPoint.getLeftCornerX();
    int Ay = twoPoint.getLeftCornerY();
    int Aw = twoPoint.getWidth();
    int Ah = twoPoint.getHeight();
    Stack<IShape> lastList = new Stack<>();
    for (IShape shape : shapeList.getShapeList()) {
      int Bx = shape.getShape().getTwoPoint().getLeftCornerX();
      int By = shape.getShape().getTwoPoint().getLeftCornerY();
      int Bw = shape.getShape().getTwoPoint().getWidth();
      int Bh = shape.getShape().getTwoPoint().getHeight();
      if (Bx + Bw > Ax && By + Bh > Ay && Ax + Aw > Bx && Ay + Ah > By) {
        if (shape.getShape().isGroup()) {
          groupChecker(shape);
          return;
        }
        lastList.add(shape);
      }
    }
    shapeList.getSelectList().add(lastList);
  }

  void groupChecker(IShape shape) {
    for (Stack<IShape> groupList: shapeList.getGroupList()) {
      if (groupList.contains(shape)) shapeList.getSelectList().add(groupList);
    }
  }
}
