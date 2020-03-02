package com.paul.stringtheory_justplay.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;


public class background extends View {

    public background(Context context) {
        super(context);

        init(null);
    }

    public background(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);

    }

    public background(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public background(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);

    }

    private void init(@Nullable AttributeSet set) {

    }

    @Override
    protected void onDraw(Canvas canvas){

        //define paint object to colour circle
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.rgb(66,66,66));

        //define circle parameters
        float cx = -150;
        int cy = (int) ((getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
        //above is the distance from the baseline to the center

        float radius = 350f;

        //draw circle
        canvas.drawCircle(cx, cy, radius, paint);
        //canvas.drawRect(rect, paint);


    }
}
