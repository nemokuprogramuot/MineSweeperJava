package org.example;

public class MineCell extends Cell {


    @Override
    public boolean isMine() {
        return true;
    }

    public void setDisplayValue() {
        displayValue = mineIcon;
    }
}
