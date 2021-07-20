package model;

import model.interfaces.IStrategy;

/**
 * This is context for IStrategy, it allows CreateShape, SelectShape and MoveShape run their own method
 */
public class Context {
    private IStrategy iStrategy;

    public void setMouseMode(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void execute(){
        iStrategy.run();
    }
}
