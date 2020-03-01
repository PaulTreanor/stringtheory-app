package com.paul.stringtheory_justplay.Views.guitarBody;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

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

    public guitarBody(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    private void init(@Nullable AttributeSet set){

    }

    protected void onDraw(Canvas canvas){
        //define circle parameters
        float cx = -1000;
        float cy = 540;
        float radius = 1600f;

        //define paint object to colour shapes
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.rgb(160,82,45));

        //draw circle and rectangle
        canvas.drawCircle(cx, cy, radius, paint);
    }
}
