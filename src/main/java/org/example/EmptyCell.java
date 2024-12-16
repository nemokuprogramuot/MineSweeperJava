package org.example;

public class EmptyCell extends Cell {

    private int neighborMines = 0;



    public void addNeighborMineValue(){
        neighborMines++;
    }

    public void setDisplayValue(){
        if(isRevealed){
            displayValue = "\033[34m" + Integer.toString(neighborMines)+ "\033[0m";
        }

    }

    @Override
    public boolean isMine() {
        return false;
    }

    public int getNeighborMines(){
        return(neighborMines);
    }
}
