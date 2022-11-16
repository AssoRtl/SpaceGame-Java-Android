package com.example.spacegamev2;

import android.content.Context;

public class Boom extends SpaceBody{

    public Boom(Context context) {
        bitmapId = R.drawable.boom;
        size = 10;
        x=70;
        y=GameView.maxY - size - 1;
        init(context);
    }
}