package ru.netology;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
    private Deque<FrogCommand> history = new ArrayDeque<>();

    public void add(FrogCommand c) {
        history.addLast(c);
    }

    public FrogCommand remove() {
        return history.removeLast();
    }

    public FrogCommand peekLast() {
        return history.peekLast();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}
