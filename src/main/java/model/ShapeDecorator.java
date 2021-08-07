package model;

import model.interfaces.IMovementObserver;

public abstract class ShapeDecorator implements IMovementObserver {
    protected IMovementObserver observer;

    public ShapeDecorator(IMovementObserver observer) {
        this.observer = observer;
    }
}
