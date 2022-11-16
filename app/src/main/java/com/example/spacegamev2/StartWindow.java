package com.example.spacegamev2;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class StartWindow extends AppCompatActivity implements View.OnClickListener{
    static ImageButton btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_window);
        getSupportActionBar().hide();
        btn1 = (ImageButton)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
        if (GameView.gameRunning==false){
        GameView.firstTime=true;
        GameView.gameRunning=true;
        GameView.asteroids.clear();
        GameView.GameOverTime=0;
        MainActivity.isLeftPressed=false;
        MainActivity.isRightPressed=false;
        MainActivity.i=0;
        }
    }
}