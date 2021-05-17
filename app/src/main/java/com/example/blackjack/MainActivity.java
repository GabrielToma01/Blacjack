package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PlayD(View v) {

        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }

    public void PlayF(View v) {

        Intent i = new Intent(this, GameF.class);
        startActivity(i);
    }

}