package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButClickMethod(View view) {
        Button button = (Button) view;
        int CellID = 0;
        switch (button.getId()) {
            case R.id.btn1:
                CellID = 1;
                break;
            case R.id.btn2:
                CellID = 2;
                break;
            case R.id.btn3:
                CellID = 3;
                break;
            case R.id.btn4:
                CellID = 4;
                break;
            case R.id.btn5:
                CellID = 1;
                break;
            case R.id.btn6:
                CellID = 6;
                break;
            case R.id.btn7:
                CellID = 7;
                break;
            case R.id.btn8:
                CellID = 8;
                break;
            case R.id.btn9:
                CellID = 9;
                break;
        }
        PlayGame(CellID, button);
    }

    int ActivePlayer = 1;//1 for first and  for second
    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();

    private void PlayGame(int celid, Button btnSlected) {
        if (ActivePlayer == 1) {
            btnSlected.setText("X");
            btnSlected.setBackgroundColor(Color.GREEN);
            Player1.add(celid);
            //ActivePlayer = 2;
            AutoPlay();
        } else if (ActivePlayer == 2) {
            btnSlected.setBackgroundColor(Color.YELLOW);
            Player2.add(celid);
            ActivePlayer = 1;
        }
        btnSlected.setEnabled(false);
        CheckWinner();
    }

    private void AutoPlay() {
        ArrayList<Integer> EmptyCell = new ArrayList<Integer>();
        for (int cellID = 1; cellID < 10; cellID++) {
            if (!(Player1.contains(cellID) || Player2.contains(cellID))) {
                EmptyCell.add(cellID);
            }
        }
        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCell.size() - 0) + 0;
        int CellID = EmptyCell.get(RandIndex);
        Button btnSelect;
        switch (CellID) {
            case 1:
                btnSelect =  findViewById(R.id.btn1);
                break;
            case 2:
                btnSelect =  findViewById(R.id.btn2);
                break;
            case 3:
                btnSelect =  findViewById(R.id.btn3);
                break;
            case 4:
                btnSelect =  findViewById(R.id.btn4);
                break;
            case 5:
                btnSelect = findViewById(R.id.btn5);
                break;
            case 6:
                btnSelect =  findViewById(R.id.btn6);
                break;
            case 7:
                btnSelect =  findViewById(R.id.btn7);
                break;
            case 8:
                btnSelect =  findViewById(R.id.btn8);
                break;
            case 9:
                btnSelect = findViewById(R.id.btn9);
                break;
            default:
                btnSelect =  findViewById(R.id.btn1);
                break;
        }
        ActivePlayer = 2;
        PlayGame(CellID,btnSelect);

    }


    private void CheckWinner() {
        int winner = -1;
        //row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2;
        }
        //row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2;
        }
        //row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2;
        }
        //Column 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2;
        }
        //Column 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2;
        }
        //Column 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2;
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is the Winner", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Player 2 is the Winner", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
