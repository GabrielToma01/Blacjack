package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;


public class Dealer extends AppCompatActivity {
    public int y = 0;
    public int playerScore = 0;

    Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer);
        setTitle("Dealer");
        Intent intent = getIntent();
        playerScore = intent.getIntExtra("PlayerScore", 0);

        myTimer = new Timer();

        findViewById(R.id.button5).setOnClickListener(v -> {
            myTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(() -> {
                        DealerC();
                    });
                }

            }, 500, 2000);
        });
    }


    public void DealerC() {
        int[] images = new int[]{1, 2, R.drawable.c2, R.drawable.d3, R.drawable.h4, R.drawable.s5, R.drawable.c6, R.drawable.d7, R.drawable.h8, R.drawable.s9, R.drawable.c10, R.drawable.da, R.drawable.hj, R.drawable.sq, R.drawable.ck};
        Random rand = new Random();

        int i = rand.nextInt(15);
        if (i == 0 || i == 1) {
            i = rand.nextInt(15);
        }
        //imageView.setImageResource(images[rand.nextInt(images.length)]);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(images[i]);
        TextView tv1 = (TextView) findViewById(R.id.score);
        y = y + i;
        tv1.setText("Score: " + y);
        if (y > 21) {
            myTimer.cancel();
            Intent q = new Intent(this, MainActivity.class);
            AlertDialog alertDialog = new AlertDialog.Builder(Dealer.this).create();
            alertDialog.setTitle("You Won!");
            alertDialog.setMessage("Dealer jumped over 21!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "back to menu", (dialog, which) -> {
                dialog.dismiss();
                startActivity(q);
            });
            alertDialog.show();
        }
        else if (y > playerScore) {
            myTimer.cancel();
            Intent q = new Intent(this, MainActivity.class);
            AlertDialog alertDialog = new AlertDialog.Builder(Dealer.this).create();
            alertDialog.setTitle("You lost!");
            alertDialog.setMessage("The Dealer Won having " + y + " !");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "back to menu", (dialog, which) -> {
                dialog.dismiss();
                startActivity(q);
            });
            alertDialog.show();
        }
    }


    public void Stop (View v){
        myTimer.cancel();
        Intent q = new Intent(this, MainActivity.class);
        AlertDialog alertDialog = new AlertDialog.Builder(Dealer.this).create();
        alertDialog.setTitle("You lost");
        alertDialog.setMessage("You forfeited");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "back to menu", (dialog, which) -> {
            dialog.dismiss();
            startActivity(q);
        });
        alertDialog.show();
    }
}