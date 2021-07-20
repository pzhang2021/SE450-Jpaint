package model;

import model.interfaces.IShape;

/**
 *     This is Factory method pattern.
 *     Rectangle, Triangle and Ellipse instances are created in ShapeFactory according to their shape type
 */
public class ShapeFactory {
    public IShape getShape(Shape shape) {
        if (shape.getShapeType() == null) return null;
        else if (shape.getShapeType() == ShapeType.RECTANGLE) {
            return new Rectangle(shape);
        }
        else if (shape.getShapeType() == ShapeType.TRIANGLE) {
            return new Triangle(shape);
        }
        else if (shape.getShapeType() == ShapeType.ELLIPSE) {
            return new Ellipse(shape);
        }
        return null;
    }
}
