package model;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Stack;

public class ShapeList {

    /*
    Shape list is the class mainly for storing undo, redo shape(s) information.
    This class initiate at the beginning of the program so other classes are able to access it.
     */

    PaintCanvasBase paintCanvas;
    Stack<Shape> shapeList = new Stack<>();
    Stack<Shape> undoRedoShapeList = new Stack<>();

    public ShapeList(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void addShape(Shape shape) {
        shapeList.add(shape);
        shape.draw(paintCanvas.getGraphics2D());
    }

    public void redraw() {
        // clear previous drawing with white background, assume the maximum resolution is 4k
        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(Color.white);
        g.fillRect(0,0,3840,2160);

        for(Shape shape : shapeList) {
            shape.draw(g);
        }
    }

    public Stack<Shape> getShapeList() {
        return shapeList;
    }

    public Stack<Shape> getUndoRedoShapeList() {
        return undoRedoShapeList;
    }
}
