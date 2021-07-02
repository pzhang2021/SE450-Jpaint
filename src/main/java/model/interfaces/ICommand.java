package model.interfaces;

public interface ICommand {
    void run();
    void undo();
    void redo();
}
