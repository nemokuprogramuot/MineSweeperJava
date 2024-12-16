package org.example;

import java.util.Random;

public class Board {
    private Cell[][] cells;
    private int numMines;
    private int rows;
    private int cols;


    public Board(int rows, int cols, int numMines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        cells = new Cell[rows][cols];

        initializeCells();
        placeMines();
        setNeigboringMines();
    }

    private void initializeCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new EmptyCell();
            }
        }
    }

    public String getCell(int row, int col) {
        return cells[row][col].getDisplayValue();
    }

    public void revealCell(int row, int col) {

        if (cells[row][col] instanceof EmptyCell) {
            cells[row][col].reveal();

            checkIfCellEmpty(row, col);

            ((EmptyCell) cells[row][col]).setDisplayValue();

        }
    }

    public void checkIfCellEmpty(int row, int col) {
        if (((EmptyCell) cells[row][col]).getNeighborMines() == 0) {

            for (int i2 = -1; i2 <= 1; i2++) {
                for (int j2 = -1; j2 <= 1; j2++) {

                    int neighborRow = row + i2;
                    int neighborCol = col + j2;

                    if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                        if (!cells[neighborRow][neighborCol].isRevealed()) {
                            revealCell(neighborRow, neighborCol);
                        }
                    }

                }
            }
        }
    }

    void placeMines() {
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < numMines) {
            int row = rand.nextInt(rows);
            int col = rand.nextInt(cols);

            if (!cells[row][col].isMine()) {
                cells[row][col] = new MineCell();
                placedMines++;

            }
        }
    }

    private void setNeigboringMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isMine()) {
                    checkNighboringMines(i, j);
                }
            }
        }
    }

    public void checkNighboringMines(int i, int j) {
        for (int i2 = -1; i2 <= 1; i2++) {
            for (int j2 = -1; j2 <= 1; j2++) {

                int neighborRow = i + i2;
                int neighborCol = j + j2;

                if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                    addNeigborMineValue(neighborRow, neighborCol);
                }
            }
        }

    }

    public void addNeigborMineValue(int neighborRow, int neighborCol) {
        if (cells[neighborRow][neighborCol] instanceof EmptyCell) {
            ((EmptyCell) cells[neighborRow][neighborCol]).addNeighborMineValue();
        }
    }

    public void flagCell(int row, int col) {
        cells[row][col].toggleFlag();
    }

    public boolean isMine(int row, int col) {
        return cells[row][col].isMine();
    }

    public void revealMines(int row, int col) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isMine()) {
                    ((MineCell) cells[i][j]).setDisplayValue();
                }
            }
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!cells[i][j].isMine() && !cells[i][j].isRevealed()) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isFlagged(int row, int col) {
        return cells[row][col].getIsFlagged();
    }

}
