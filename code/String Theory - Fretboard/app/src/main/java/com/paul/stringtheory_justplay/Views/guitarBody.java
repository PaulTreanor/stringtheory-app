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

public class guitarBody extends View{

    public guitarBody(Context context) {
        super(context);
        init(null);
    }

    public guitarBody(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public guitarBody(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public guitarBody(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    protected void onDraw(Canvas canvas){

        //define paint object to colour shapes
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.rgb(160,82,45));
        @SuppressLint("DrawAllocation") Paint paintBlack = new Paint();
        paintBlack.setColor(Color.rgb(0,0,0));

        //define circle parameters
        float cx = -1000;
        float cy = (int) ((getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
        //above is the distance from the baseline to the center

        float r1 = 1600f;
        float r2 = 1590f;

        //draw circle
        canvas.drawCircle(cx, cy, r1, paintBlack);
        canvas.drawCircle(cx, cy, r2, paint);
    }
}
