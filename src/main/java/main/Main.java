package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseController;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;

/**
 * We already have View (UI) initiated in main, so I create ShapeList as data model and
 * MouseController as controller to satisfy with MVC pattern ShapeList and MouseController instances
 * are created in main class
 */
public class Main {

  public static void main(String[] args) {
    ShapeList shapeList = new ShapeList();
    PaintCanvasBase paintCanvas = new PaintCanvas(shapeList);
    IGuiWindow guiWindow = new GuiWindow(paintCanvas);
    IUiModule uiModule = new Gui(guiWindow);
    ApplicationState appState = new ApplicationState(uiModule);
    IJPaintController controller = new JPaintController(uiModule, appState, shapeList);
    // initiate mouse Controller and ShapeList
    MouseController mouseController = new MouseController(appState, paintCanvas, shapeList);
    paintCanvas.addMouseListener(mouseController);
    controller.setup();

  }
}
