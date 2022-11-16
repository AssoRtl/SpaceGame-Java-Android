package com.example.spacegamev2;

import android.content.Context;

public class Ship extends SpaceBody{

    public Ship(Context context) {
        bitmapId = R.drawable.newship2;
        size = 4;
        x=13;
        y=GameView.maxY - size - 1;
        speed = (float) 0.5;
        init(context);
    }

    @Override
    public void update() {
        if(MainActivity.isLeftPressed && x >= 0){
            x -= speed;
        }
        if(MainActivity.isRightPressed && x <= GameView.maxX - 5){
            x += speed;
        }
        if(MainActivity.isupPressed && y >= 0){
            y -= speed;
        }
        if(MainActivity.isdownPressed && y <= GameView.maxY - 5){
            y += speed;
        }
    }

}
