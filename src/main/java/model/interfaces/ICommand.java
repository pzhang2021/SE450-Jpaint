package model.interfaces;

public interface ICommand {
    /*
    This is abstract factory pattern
    Sprint 1: UndoCommand, RedoCommand and CreateShape implement it
    */
    void run();
    void undo();
    void redo();
}
