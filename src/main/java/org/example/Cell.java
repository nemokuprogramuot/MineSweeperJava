package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Cell {
    protected String flagIcon = "F";
    protected String questionMarkIcon = "?";
    protected String mineIcon = "*";


    protected boolean isFlagged = false;
    protected boolean isRevealed = false;
    protected String displayValue = questionMarkIcon;

    public abstract boolean isMine();

    public void reveal() {
        isRevealed = true;
    }

    public void toggleFlag() {
        isFlagged = !isFlagged;
        displayValue = (isFlagged && !isRevealed) ? flagIcon :
                (!isFlagged && !isRevealed) ? questionMarkIcon : displayValue;

    }

    public boolean getIsFlagged() {
        return isFlagged;
    }

}
