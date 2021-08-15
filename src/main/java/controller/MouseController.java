package controller;

import model.*;
import model.Command.CreateCommand;
import model.Command.MoveCommand;
import model.Command.SelectCommand;
import model.Shape;
import model.interfaces.IStrategy;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This is MVC pattern, it is controller to communicate between the data (ShapeList) and the UI
 * (PaintCanvasBase). MouseAdapter (by default) has own way to detect the condition of mouse
 * (function of clicked, pressed, released, etc.) Coordinate, CreateShape and Shape instances are
 * created in MouseController.
 */
public class MouseController extends MouseAdapter {

  private final ApplicationState appState;
  private final PaintCanvasBase paintCanvas;
  private final ShapeList shapeList;
  private Coordinate startPoint;

  public MouseController(ApplicationState appState, PaintCanvasBase paintCanvas,
      ShapeList shapeList) {
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
    TwoPoint twoPoint = new TwoPoint(startPoint, new Coordinate(e.getX(), e.getY()));
    // builder pattern initiate
    Shape newShape = new ShapeBuilder()
        .setPaintCanvas(paintCanvas)
        .setTwoPoint(twoPoint)
        .setPrimaryColor(appState.getActivePrimaryColor().getColor())
        .setSecondaryColor(appState.getActiveSecondaryColor().getColor())
        .setShapeType(appState.getActiveShapeType())
        .setShadingType(appState.getActiveShapeShadingType())
        .build();
    // strategy pattern initiate
    IStrategy mouseMode;
    Context strategy = new Context();
    if (appState.getActiveMouseMode() == MouseMode.DRAW) {
      mouseMode = new CreateCommand(newShape, shapeList);
    } else if (appState.getActiveMouseMode() == MouseMode.SELECT) {
      mouseMode = new SelectCommand(twoPoint, shapeList);
    } else {
      mouseMode = new MoveCommand(twoPoint, shapeList);
    }
    strategy.setMouseMode(mouseMode);
    strategy.execute();
  }
}
