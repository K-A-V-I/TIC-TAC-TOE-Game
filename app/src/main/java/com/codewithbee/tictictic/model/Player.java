package com.codewithbee.tictictic.model;

import android.view.View;

import java.util.ArrayList;


public abstract class Player {
    protected boolean active;
    protected ArrayList<Integer> cellsChosen = new ArrayList<>();
    protected Board board;
    protected int playerMark;

    public Player(Board board, int playerMark) {
        this.board = board;
        this.playerMark = playerMark;
    }

    public ArrayList<Integer> getCellsChosen() {
        return cellsChosen;
    }

    public void addChosenCell(Integer cellNumber) {
        cellsChosen.add(cellNumber);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void playTurn(View view);
}
