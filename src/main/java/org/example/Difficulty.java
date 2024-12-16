package org.example;

public interface Difficulty {
    int getRows();
    int getCols();
    int getNumMines();
}

class EasyDifficulty implements Difficulty {
    @Override
    public int getRows() { return 9; }
    @Override
    public int getCols() { return 9; }
    @Override
    public int getNumMines() { return 10; }
}

class MediumDifficulty implements Difficulty {
    @Override
    public int getRows() { return 16; }
    @Override
    public int getCols() { return 16; }
    @Override
    public int getNumMines() { return 40; }
}

class HardDifficulty implements Difficulty {
    @Override
    public int getRows() { return 16; }
    @Override
    public int getCols() { return 30; }
    @Override
    public int getNumMines() { return 99; }
}

class TestDifficulty implements Difficulty {
    @Override
    public int getRows() { return 9; }
    @Override
    public int getCols() { return 9; }
    @Override
    public int getNumMines() { return 2; }
}