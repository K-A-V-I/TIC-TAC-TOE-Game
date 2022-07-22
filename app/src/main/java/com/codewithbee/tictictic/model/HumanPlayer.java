package com.codewithbee.tictictic.model;

import android.view.View;
import android.widget.Button;


public class HumanPlayer extends Player {

    public HumanPlayer(Board board, int playerMark) {
        super(board, playerMark);
    }

    @Override
    public void playTurn(View view) {
        Button buttonSelected = (Button) view;
        // disable the button to avoid re-clicking on it.
        buttonSelected.setEnabled(false);
        // display player's mark on the button selected.
        buttonSelected.setBackgroundResource(playerMark);
        // occupy a cell to be chosen by this player.
        addChosenCell(buttonSelected.getId());
        board.occupyCell(buttonSelected.getId());
    }
}


