package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cell {
    private boolean isMine;
    private boolean isFlagged;
    private boolean isRevealed;
    private int neighborMines = 0;
    private String displayValue = "\033[37m"+"?" +"\033[0m" ;


    public Cell() {

    }

    public void reveal(){
        isRevealed = true;
    }
    public void toggleFlag(){
        isFlagged = !isFlagged;

        if(isFlagged && !isRevealed){
            displayValue = "\033[32m"+"F"+"\033[0m";
        }
        else if(!isFlagged  && !isRevealed){
            displayValue = "\033[37m"+"?" +"\033[0m";
        }

    }
    public void setDisplayValue(){
        if(isRevealed){
            displayValue = "\033[34m" + Integer.toString(neighborMines)+ "\033[0m";
        }

    }
    public void setDisplayValueToMine(){
        displayValue = "\033[31m"+"*"+"\033[0m";
    }
    public void setMine(){
        isMine = true;
    }

    public void addNeighborMineValue(){
        neighborMines++;
    }
    public boolean getIsFlagged(){
        return isFlagged;
    }


}
