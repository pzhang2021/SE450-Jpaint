package model;

import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Stack;

public class ShapeList{

    /*
    Shape list is the class mainly for storing undo, redo shape(s) information.
    This class initiate at the beginning of the program so other classes are able to access it.
     */

    private PaintCanvasBase paintCanvas;
    private Stack<IShape> shapeList = new Stack<>();
    private Stack<IShape> undoRedoShapeList = new Stack<>();

    public ShapeList(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void addShape(IShape iShape) {
        shapeList.add(iShape);
        iShape.draw(paintCanvas.getGraphics2D());
    }

//    public void draw() {
//        // clear previous drawing with white background, assume the maximum resolution is 4k
//        Graphics2D g = paintCanvas.getGraphics2D();
//        g.setColor(Color.white);
//        g.fillRect(0,0,3840,2160);
//
//        for(IShape iShape : shapeList) {
//            iShape.draw(g);
//        }
//    }

    public Stack<IShape> getShapeList() {
        return shapeList;
    }

    public Stack<IShape> getUndoRedoShapeList() {
        return undoRedoShapeList;
    }
}
