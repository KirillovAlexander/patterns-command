package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("+N - прыгни на N шагов направо\n" +
                "-N - прыгни на N шагов налево\n" +
                "<< - Undo (отмени последнюю команду)\n" +
                ">> - Redo (повтори отменённую команду)\n" +
                "!! - повтори последнюю команду\n" +
                "0 - выход");
        CommandHistory commandHistory = new CommandHistory();
        CommandHistory commandAbortedHistory = new CommandHistory();
        Frog frog = new Frog();
        frog.printField();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            if (input.equals("0")) break;
            if (input.startsWith("+")) {
                int steps = Integer.parseInt(input.substring(1));
                FrogCommand cmd = FrogCommands.jumpRightCommand(frog, steps);
                commandHistory.add(cmd);
                cmd.execute();
            }
            if (input.startsWith("-")) {
                int steps = Integer.parseInt(input.substring(1));
                FrogCommand cmd = FrogCommands.jumpLeftCommand(frog, steps);
                commandHistory.add(cmd);
                cmd.execute();
            }
            if (input.equals("<<")) {
                if (!commandHistory.isEmpty()) {
                    FrogCommand cmd = commandHistory.remove();
                    cmd.undo();
                    commandAbortedHistory.add(cmd);
                }
            }
            if (input.equals(">>")) {
                if (!commandAbortedHistory.isEmpty()) {
                    FrogCommand cmd = commandAbortedHistory.remove();
                    cmd.execute();
                    commandHistory.add(cmd);
                }
            }
            if (input.equals("!!")) {
                if (!commandHistory.isEmpty()) {
                    FrogCommand cmd = commandHistory.peekLast();
                    cmd.execute();
                    commandHistory.add(cmd);
                }
            }
            frog.printField();
        }
    }

}
