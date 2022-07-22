package com.codewithbee.tictictic.model;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.codewithbee.tictictic.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Board extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
    }

        private ArrayList<Button> emptyCells = new ArrayList<Button>();
        private ArrayList<ArrayList<Integer>> winningCells = new ArrayList<>();
        public static int BOARD_CELLS_NUMBER = 9;
        
        public Board() {
            initEmptyCells();
            initWinningCells();
        }

        // getter method for empty cells data structure. (changes with instances)
        public ArrayList<Button> getEmptyCells() {
            return emptyCells;
        }

        // getter method for winning cells data structure. (never changes with instances)
        public ArrayList<ArrayList<Integer>> getWinningCells() {
            return winningCells;
        }

        // occupy cell == remove from empty cells data structure.
        public void occupyCell(Integer buttonID) {
            if (emptyCells.size() >= 1)
                emptyCells.remove(buttonID);
        }
    private void initEmptyCells() {
        emptyCells.add(button1);
        emptyCells.add(button2);
        emptyCells.add(button3);
        emptyCells.add(button4);
        emptyCells.add(button5);
        emptyCells.add(button6);
        emptyCells.add(button7);
        emptyCells.add(button8);
        emptyCells.add(button9);
    }
    private void initWinningCells() {
        // ROWS Winning Condition.
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button1, R.id.button2, R.id.button3)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button4, R.id.button5, R.id.button6)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button3, R.id.button6, R.id.button9)));
        // COLS Winning Condition.
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button1, R.id.button4, R.id.button7)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button2, R.id.button5, R.id.button8)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button3, R.id.button6, R.id.button9)));
        // Diagonals Winning Condition.
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button1, R.id.button5, R.id.button9)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button3, R.id.button5, R.id.button7)));
    }

}
