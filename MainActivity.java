package com.example.dkool.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button topLeft;
    Button topMid;
    Button topRight;
    Button midLeft;
    Button midMid;
    Button midRight;
    Button botLeft;
    Button botMid;
    Button botRight;
    char[][] board = {{' ',' ',' '},
                      {' ',' ',' '},
                      {' ',' ',' '}};
    boolean player1Turn = true;
    int moveCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topLeft = (Button) findViewById(R.id.button);
        topMid = (Button) findViewById(R.id.button2);
        topRight = (Button) findViewById(R.id.button3);
        midLeft = (Button) findViewById(R.id.button4);
        midMid = (Button) findViewById(R.id.button5);
        midRight = (Button) findViewById(R.id.button6);
        botLeft = (Button) findViewById(R.id.button7);
        botMid = (Button) findViewById(R.id.button8);
        botRight = (Button) findViewById(R.id.button9);
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button);
                if (player1Turn) {
                    tx.setText("X");
                    board[0][0] = 'X';
                }
                else {
                    tx.setText("O");
                    board[0][0] = 'O';
                }
                if (isGameWon(0, 0)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                topLeft.setClickable(false);
            }
        });

        topMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button2);
                if (player1Turn) {
                    tx.setText("X");
                    board[0][1] = 'X';
                }
                else {
                    tx.setText("O");
                    board[0][1] = 'O';
                }
                if (isGameWon(0, 1)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                topMid.setClickable(false);
            }
        });

        topRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button3);
                if (player1Turn) {
                    tx.setText("X");
                    board[0][2] = 'X';
                }
                else {
                    tx.setText("O");
                    board[0][2] = 'O';
                }
                if (isGameWon(0, 2)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                topRight.setClickable(false);
            }
        });

        midLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button4);
                if (player1Turn) {
                    tx.setText("X");
                    board[1][0] = 'X';
                }
                else {
                    tx.setText("O");
                    board[1][0] = 'O';
                }
                if (isGameWon(1, 0)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                midLeft.setClickable(false);
            }
        });

        midMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button5);
                if (player1Turn) {
                    tx.setText("X");
                    board[1][1] = 'X';
                }
                else {
                    tx.setText("O");
                    board[1][1] = 'O';
                }
                if (isGameWon(1, 1)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                midMid.setClickable(false);
            }
        });

        midRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button6);
                if (player1Turn) {
                    tx.setText("X");
                    board[1][2] = 'X';
                } else {
                    tx.setText("O");
                    board[1][2] = 'O';
                }
                if (isGameWon(1, 2)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                midRight.setClickable(false);
            }
        });

        botLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button7);
                if (player1Turn) {
                    tx.setText("X");
                    board[2][0] = 'X';
                }
                else {
                    tx.setText("O");
                    board[2][0] = 'O';
                }
                if (isGameWon(2, 0)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                botLeft.setClickable(false);
            }
        });

        botMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button8);
                if (player1Turn) {
                    tx.setText("X");
                    board[2][1] = 'X';
                }
                else {
                    tx.setText("O");
                    board[2][1] = 'O';
                }
                if (isGameWon(2, 1)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                botMid.setClickable(false);
            }
        });

        botRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCount += 1;
                TextView tx = (TextView) findViewById(R.id.button9);
                if (player1Turn) {
                    tx.setText("X");
                    board[2][2] = 'X';
                }
                else {
                    tx.setText("O");
                    board[2][2] = 'O';
                }
                if (isGameWon(2, 2)) {
                    Intent win = new Intent(MainActivity.this, DisplayWin.class);
                    if (player1Turn) {
                        win.putExtra("winner", "X Wins!");
                    }
                    else {
                        win.putExtra("winner", "O Wins!");
                    }
                    startActivity(win);
                }
                if (moveCount == 9) {
                    Intent draw = new Intent(MainActivity.this, DisplayWin.class);
                    draw.putExtra("winner", "Draw!");
                    startActivity(draw);
                }
                player1Turn = !player1Turn;
                botRight.setClickable(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isGameWon(int row, int col) {
        boolean horizWin = false;
        boolean vertWin = false;
        boolean diagWin = false;
        for (int i = 0; i < 3; i += 1) {
            if (board[row][i] != board[row][col]) {
                horizWin = false;
                break;
            }
            else {
                horizWin = true;
            }
        }

        for (int i = 0; i < 3; i += 1) {
            if (board[i][col] != board[row][col]) {
                System.out.println("[i][col]  " + board[i][col] + "  [row][col]   " + board[row][col]);
                vertWin = false;
                break;
            }
            else {
                System.out.println("[i][col]  " + i + "  " + col + "   " + board[i][col] + "  [row][col]   " + board[row][col]);
                vertWin = true;
            }
        }

        if (row == col || col + row == 2) {
            for (int i = 0; i < 3; i += 1) {
                if (board[i][i] != board[row][col]) {
                    diagWin = false;
                    break;
                }
                else {
                    diagWin = true;
                }
            }

            if (board[2][0] == board[row][col] && board[1][1] == board[row][col] && board[0][2] == board[row][col]) {
                diagWin = true;
            }
        }


        System.out.println("vert: " + vertWin + "       horiz: " + horizWin + "      diag: " + diagWin);
        return vertWin || horizWin || diagWin;
    }

}
