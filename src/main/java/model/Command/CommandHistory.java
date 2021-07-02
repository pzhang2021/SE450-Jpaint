package model.Command;

import model.interfaces.ICommand;

import java.util.Stack;

public class CommandHistory {
    private static final Stack<ICommand> undoStack = new Stack<>();
    private static final Stack<ICommand> redoStack = new Stack<>();

    public static void add(ICommand cmd) {
        undoStack.push(cmd);
        redoStack.clear();
    }

    public static boolean undo() {
        boolean result = !undoStack.empty();
        if (result) {
            ICommand c = undoStack.pop();
            redoStack.push(c);
            c.undo();
        }
        return result;
    }

    public static boolean redo() {
        boolean result = !redoStack.empty();
        if (result) {
            ICommand c = redoStack.pop();
            undoStack.push(c);
            c.redo();
        }
        return result;
    }
}