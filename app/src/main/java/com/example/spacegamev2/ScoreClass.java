package com.example.spacegamev2;

public class ScoreClass {
    public static void controlScore() {
        if(MainActivity.a>=10)
        {MainActivity.Score.setText(Integer.toString(MainActivity.i));
            MainActivity.i++;
            MainActivity.a=0;
        }
        else MainActivity.a++;
    }
}
