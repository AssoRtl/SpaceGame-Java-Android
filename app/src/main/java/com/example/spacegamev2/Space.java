package com.example.spacegamev2;

import android.content.Context;

public class Space extends SpaceBody{
    public Space(Context context) {
        bitmapId = R.drawable.space;
        size = 50;
        x=-15;
        y=0;
        speed=-speed;
        init(context);
    }
}
