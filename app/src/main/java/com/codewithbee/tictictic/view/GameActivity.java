package com.codewithbee.tictictic.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.codewithbee.tictictic.R;
import com.codewithbee.tictictic.controller.GameController;
import com.codewithbee.tictictic.model.Board;
import com.codewithbee.tictictic.model.DeterministicComputerPlayer;
import com.codewithbee.tictictic.model.HumanPlayer;
import com.codewithbee.tictictic.model.Player;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private Player player1;
    private Player player2;
    private boolean isSoloGameMode;
    private GameController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        isSoloGameMode = getIntent().getBooleanExtra(getString(R.string.intent_extra_key_solo_game_mode), true);
        setupActivity();
    }

    public void buClick(View view) {
        if (isSoloGameMode)
            controller.playSoloMode(view);
        else
            controller.playMultiMode(view);
        // check winning  or tie condition and show appropriate notification accordingly.
        if (controller.isPlayerWinner(player1))
            notifyResultAndEndGame(R.string.x_won);
        else if (controller.isPlayerWinner(player2))
            notifyResultAndEndGame(R.string.o_won);
        else if (controller.isTieGame())
            notifyResultAndEndGame(R.string.tie_game);
    }

    private void setupActivity() {
        Board board = new Board();
        // Player 1 is always Human, always takes X mark and always starts first.
        player1 = new HumanPlayer(board, R.drawable.x);
        player1.setActive(true);
        // Player 2 is based on whether this is a solo-player mode game or multi-player mode game.
        player2 = isSoloGameMode ? new DeterministicComputerPlayer(board, R.drawable.o) : new HumanPlayer(board, R.drawable.o);
        controller = new GameController(board, player1, player2);
    }

    private void notifyResultAndEndGame(int messageRes) {
        // Show notification and then after a delay of 1.5 seconds finish activity.
        Toast.makeText(this, messageRes, Toast.LENGTH_LONG).show();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        }, 1500);
    }
}
