package controller;

import model.*;
import model.Command.CreateCommand;
import model.Command.MoveCommand;
import model.Command.SelectCommand;
import model.Shape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *     This is MVC pattern, it is controller to communicate between the data (ShapeList) and the UI (PaintCanvasBase).
 *     MouseAdapter (by default) has own way to detect the condition of mouse (function of clicked, pressed, released, etc.)
 *     Coordinate, CreateShape and Shape instances are created in MouseController.
 */
public class MouseController extends MouseAdapter {

    private final ApplicationState appState;
    private final PaintCanvasBase paintCanvas;
    private final ShapeList shapeList;
    private Coordinate startPoint;

    public MouseController(ApplicationState appState, PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Coordinate(e.getX(), e.getY());
        // System.out.println("start point at " + startPoint.getX() + ", " + startPoint.getY());
    }

    /*
    Once user release the mouse, all parameters will pass to shape builder and it will show the result on canvas
    correspond to mouse mode
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        Context strategy = new Context();
        TwoPoint twoPoint = new TwoPoint(startPoint, new Coordinate(e.getX(), e.getY()));
        // System.out.println("end point at " + endPoint.getX() + ", " + endPoint.getY());
        Shape newShape = new Shape.ShapeBuilder()
                .setPaintCanvas(paintCanvas)
                .setTwoPoint(twoPoint)
                .setPrimaryColor(appState.getActivePrimaryColor().getColor())
                .setSecondaryColor(appState.getActiveSecondaryColor().getColor())
                .setShapeType(appState.getActiveShapeType())
                .setShadingType(appState.getActiveShapeShadingType())
                .build();
        if(appState.getActiveMouseMode() == MouseMode.DRAW) {
            strategy.setMouseMode(new CreateCommand(newShape, shapeList));
            strategy.execute();
        } else if(appState.getActiveMouseMode() == MouseMode.SELECT) {
            strategy.setMouseMode(new SelectCommand(twoPoint, shapeList));
            strategy.execute();
        } else {
            strategy.setMouseMode(new MoveCommand(twoPoint, shapeList));
            strategy.execute();
        }
    }
}
