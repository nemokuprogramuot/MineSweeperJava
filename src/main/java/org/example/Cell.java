package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Cell {
    protected String flagIcon = "\033[32m" + "F" + "\033[0m";
    protected String questionMarkIcon = "\033[37m" + "?" + "\033[0m";
    protected String mineIcon = "\033[31m"+"*"+"\033[0m";


    protected boolean isFlagged = false;
    protected boolean isRevealed = false;
    protected String displayValue = questionMarkIcon;

    public abstract boolean isMine();

    public void reveal(){
        isRevealed = true;
    }
    public void toggleFlag(){
        isFlagged = !isFlagged;
        displayValue = (isFlagged && !isRevealed) ? flagIcon :
                (!isFlagged && !isRevealed) ? questionMarkIcon : displayValue;

    }

    public boolean getIsFlagged() {
        return isFlagged;
    }

}
