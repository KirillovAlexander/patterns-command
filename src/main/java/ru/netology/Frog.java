package ru.netology;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    public static final char FROG   = '\u25a9';
    public static final char EMPTY = '\u25A2';

    protected int position;

    public Frog() { position = 5; }

    public boolean jump(int steps) {
        if (jumpIsValid(steps)) {
            position = position + steps;
            return true;
        } else return false;
    }

    private boolean jumpIsValid(int steps) {
        if (steps >= 0) {
            return position + steps <= MAX_POSITION;
        } else {
            return position + steps >= MIN_POSITION;
        }
    }

    public void printField() {
        for (int i = MIN_POSITION; i <= MAX_POSITION; i++) {
            if (i == position) System.out.print(FROG);
            else System.out.print(EMPTY);
        }
        System.out.print("\n");
    }
}
