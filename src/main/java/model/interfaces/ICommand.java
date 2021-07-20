package model.interfaces;

/**
 *     This is Abstract Factory Pattern
 *     Sprint 1: UndoCommand, RedoCommand, and CreateCommand implement it
 *     Sprint 2: SelectCommand and MoveCommand implement it
 */
public interface ICommand {
    void undo();
    void redo();
}
