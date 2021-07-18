package model.interfaces;

public interface ICommand {
    /*
    This is abstract factory pattern without specifying the concrete classes,
    so other class are able to override it with own method
    In sprint 1: UndoCommand, RedoCommand and CreateShape implement it
    */
    void run();
    void undo();
    void redo();
}
