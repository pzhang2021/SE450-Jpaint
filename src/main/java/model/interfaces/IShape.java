package model.interfaces;

import java.awt.*;

public interface IShape {
    /*
    This is abstract factory pattern
    Sprint 1: draw() and clear() method added, Rectangle, Triangle and Ellipse classes implement this pattern
     */
    void draw(Graphics2D g);
    void clear(Graphics2D g);
}
