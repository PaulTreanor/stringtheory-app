package com.paul.stringtheory_justplay.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Shapes extends View {

    public Shapes(Context context) {
        super(context);

        init(null);
    }

    public Shapes(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);

    }

    public Shapes(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Shapes(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);

    }

    private void init(@Nullable AttributeSet set) {

    }

    @Override
    protected void onDraw(Canvas canvas){

        //create rectangle
        Rect rect = new Rect();
        rect.top = 140;
        rect.left = 1820;
        rect.bottom = rect.top + 800;
        rect.right = rect.left + 100;

        //define circle parameters
        float cx = -150;
        float cy = 540;
        float radius = 400f;

        //define paint object to colour shapes
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.GREEN);

        //draw circle and rectangle
        canvas.drawCircle(cx, cy, radius, paint);
        canvas.drawRect(rect, paint);
    }
}
