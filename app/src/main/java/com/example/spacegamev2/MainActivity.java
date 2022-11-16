package com.example.spacegamev2;

import static com.example.spacegamev2.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public static boolean isLeftPressed = false;
    public static boolean isRightPressed = false;
    public static boolean isupPressed = false;
    public static boolean isdownPressed = false;
    static TextView Score;
    static int i=0;
    static int a = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(layout.activity_main);
        Score=findViewById(R.id.Score);
        GameView gameView = new GameView(this); // создаём gameView
        LinearLayout gameLayout = (LinearLayout) findViewById(id.gameLayout);
        gameLayout.addView(gameView);
        ImageButton leftButton = (ImageButton) findViewById(id.leftButton);
        ImageButton rightButton = (ImageButton) findViewById(id.rightButton);
        ImageButton upButton = (ImageButton) findViewById(id.upButton);
        ImageButton downButton = (ImageButton) findViewById(id.downButton);
        leftButton.setOnTouchListener(this);
        rightButton.setOnTouchListener(this);
        downButton.setOnTouchListener(this);
        upButton.setOnTouchListener(this);
    }
    public boolean onTouch(View button, MotionEvent motion) {
        switch(button.getId()) {
            case id.leftButton:
                switch (motion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isLeftPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isLeftPressed = false;
                        break;
                }
                break;

            case id.rightButton:
                switch (motion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isRightPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isRightPressed = false;
                        break;
                }
                break;
            case id.upButton:
                switch (motion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isupPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isupPressed = false;
                        break;
                }
                break;
            case id.downButton:
                switch (motion.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isdownPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isdownPressed = false;
                        break;
                }
                break;
        }
        return true;
    }
    }




