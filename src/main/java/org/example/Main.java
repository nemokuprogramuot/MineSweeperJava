package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean playAgain = true;
        String answ;
        Scanner scanner = new Scanner(System.in);

        showMenu();

        while (playAgain) {
            Game game = new Game();

            while (true) {
                clearConsole();
                game.displayCells();

                if (game.isGameOver() || game.isGameWon()) {
                    break;
                }
                answ = scanner.nextLine();
                game.handleReply(answ.trim());

            }

            System.out.print("Play again? \n 1. Yes \n 2. No \n ");
            answ = scanner.nextLine();

            if (answ.equals("2")) {
                playAgain = false;
            }
            clearConsole();
        }

    }

    static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.print("\n");
        }
    }

    static void showMenu() {
        while (true) {
            clearConsole();
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n Welcome to MineSweeper");
            System.out.println("1. Play ");
            System.out.println("2. Rules");
            System.out.println(" ");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                break;
            } else if (choice.equals("2")){
                showRules(scanner);
            }
        }

    }

    static void showRules(Scanner scanner) {
        clearConsole();
        System.out.println("How to play: \n");
        System.out.println("Reveal a cell by entering its coordinates as two numbers (e.g., 3 5). \n");
        System.out.println("If the cell contains a mine, the game is over. \n");
        System.out.println("To mark a cell as a potential mine, type f followed by the coordinates (e.g., f 2 3). \n");
        System.out.println("Good luck soldier. \n");
        System.out.println("Type anything to continue: ");
        String temp = scanner.nextLine();


    }

}