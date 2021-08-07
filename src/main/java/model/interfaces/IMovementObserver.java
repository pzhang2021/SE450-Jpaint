package model.interfaces;

import model.TwoPoint;
import model.Shape;
import java.awt.*;

/**
 * This is Observer Pattern Interface, Rectangle, Triangle and Ellipse classes implement this pattern
 * for observing and updating the movement change
 */
public interface IMovementObserver {
    void update(TwoPoint twoPoint);
    void draw();
    // void repaintOutline(Graphics g);
    Shape getShape();
}
