package com.example.blackjack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.DialogInterface;

import com.example.blackjack.R;

import java.util.Random;
public class GameP2 extends AppCompatActivity {
    public int x = 0;
    public int playerScore1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_p2);
        setTitle("Player 2");
        Intent intent = getIntent();
        playerScore1 = intent.getIntExtra("PlayerScore", 0);
    }
    public void Draw(View v)
    {
        //int[] images = new int[] {R.drawable.c2, R.drawable.d2, R.drawable.h2, R.drawable.s2, R.drawable.c3, R.drawable.d3, R.drawable.h3, R.drawable.s3, R.drawable.c4, R.drawable.d4, R.drawable.h4, R.drawable.s4, R.drawable.c5, R.drawable.d5, R.drawable.h5, R.drawable.s5, R.drawable.c6, R.drawable.d6, R.drawable.h6, R.drawable.s6, R.drawable.c7, R.drawable.d7,R.drawable.h7, R.drawable.s7, R.drawable.c8, R.drawable.d8, R.drawable.h8, R.drawable.s8, R.drawable.c9, R.drawable.d9, R.drawable.h9, R.drawable.s9, R.drawable.c10, R.drawable.d10, R.drawable.h10, R.drawable.s10, R.drawable.ca, R.drawable.da, R.drawable.ha, R.drawable.sa, R.drawable.cj, R.drawable.dj, R.drawable.hj, R.drawable.sj, R.drawable.cq, R.drawable.dq, R.drawable.hq, R.drawable.sq, R.drawable.ck, R.drawable.dk, R.drawable.hk, R.drawable.sk, };
        int[] images = new int[] {1, 2, R.drawable.c2, R.drawable.d3, R.drawable.h4, R.drawable.s5, R.drawable.c6, R.drawable.d7, R.drawable.h8, R.drawable.s9, R.drawable.c10, R.drawable.da, R.drawable.hj, R.drawable.sq, R.drawable.ck };
        Random rand = new Random();
        int i = rand.nextInt( 15);
        if (i == 0 || i == 1) {
            i = rand.nextInt( 15);
        }
        //imageView.setImageResource(images[rand.nextInt(images.length)]);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(images[i]);
        TextView tv1 = (TextView)findViewById(R.id.score);

        x = x + i;
         if(x > 21) {
            // un intent sa te duca inapoi in meniu si acolo display o alerta
            //bundle-uri
            Intent q = new Intent(this, MainActivity.class);
            AlertDialog alertDialog = new AlertDialog.Builder(GameP2.this).create();
            alertDialog.setTitle("You jumped over 21!");
            alertDialog.setMessage("Player 1 Wins!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "back to menu", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    startActivity(q);
                }
            });
            alertDialog.show();
        }
        tv1.setText("Score: " + x);
    }
    public void Stop(View v) {
        Intent q = new Intent(this, MainActivity.class);

        if(playerScore1 > x) {
            AlertDialog alertDialog = new AlertDialog.Builder(GameP2.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Player 1 Wins!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "back to menu", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            startActivity(q);
                        }

        });
            alertDialog.show();


    }
        else if(playerScore1 == x) {
            AlertDialog alertDialog = new AlertDialog.Builder(GameP2.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("It's a tie!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "back to menu", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    startActivity(q);
                }

            });
            alertDialog.show();



        }
        else if(playerScore1 < x) {
            AlertDialog alertDialog = new AlertDialog.Builder(GameP2.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Player 2 Wins!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "back to menu", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    startActivity(q);
                }

            });
            alertDialog.show();



        }
}
}