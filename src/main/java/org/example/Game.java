package org.example;

import java.util.Scanner;

public class Game {
    private Board board;
    private boolean gameOver;
    private boolean gameWon;
    private int rows;
    private int cols;
    private int numMines;

    public Game() {
        chooseDificulty();
        board = new Board(rows, cols, numMines);
    }

    public void displayCells() {
        displayHeaderMessege();
        System.out.print("  ");

        for (int i = 0; i < cols; i++) {
            if (i < 9) System.out.print("   " + (i + 1));
            else System.out.print("  " + (i + 1));
        }
        System.out.print("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    if (i < 9) System.out.print(i + 1 + "  | ");
                    else System.out.print(i + 1 + " | ");
                }

                System.out.print(board.getCell(i, j) + " | ");
            }
            System.out.print("\n");

        }
        if (!gameOver && !gameWon) System.out.print("Write coordinates here: ");


    }

    public void checkCell(int row, int col) {
        if (!board.isFlagged(row, col)&& !board.isMine(row, col)) {

            board.revealCell(row, col);

            if (board.checkWin()) {
                gameWon = true;
            }

        } else if (!board.isFlagged(row, col) && board.isMine(row, col)) {
            gameOver = true;
            board.revealMines(row, col);
        }

    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    void handleReply(String answ) {
        try {
            String[] parts = answ.split(" ");
            if (parts.length == 3 && parts[0].equalsIgnoreCase("f")) {
                board.flagCell(Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[2]) - 1);

            } else if (parts.length == 2) {
                checkCell(Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[1]) - 1);
            }
        } catch (Exception e) {
            System.out.println("Wrong input, try again"); //
        }

    }

    public void chooseDificulty() {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        Difficulty difficulty;

        System.out.println("Choose Difficulty:");
        System.out.println("1. Easy (9x9 grid, 10 mines)");
        System.out.println("2. Medium (16x16 grid, 40 mines)");
        System.out.println("3. Hard (16x30 grid, 99 mines)");
        System.out.println("4. Test (9x9 grid, 2 mines)");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> difficulty = new EasyDifficulty();
            case "2" -> difficulty = new MediumDifficulty();
            case "3" -> difficulty = new HardDifficulty();
            case "4" -> difficulty = new TestDifficulty();
            default -> {
                System.out.println("Invalid choice, defaulting to Easy.");
                difficulty = new EasyDifficulty();
            }
        }
        rows = difficulty.getRows();
        cols = difficulty.getCols();
        numMines = difficulty.getNumMines();
    }

    public void displayHeaderMessege() {
        if (gameOver) {
            System.out.println("Game Over");
        } else if (gameWon) {
            System.out.println("You win!");
        } else {
            System.out.println("Pick cell:");
        }
    }

    static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.print("\n");
        }
    }

}
