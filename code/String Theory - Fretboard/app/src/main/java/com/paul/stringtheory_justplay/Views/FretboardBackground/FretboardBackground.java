package com.paul.stringtheory_justplay.Views.FretboardBackground;

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

public class FretboardBackground extends View {
    public FretboardBackground(Context context) {
        super(context);

        init(null);
    }

    public FretboardBackground(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);

    }

    public FretboardBackground(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FretboardBackground(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);

    }

    private void init(@Nullable AttributeSet set) {

    }

    @Override
    protected void onDraw(Canvas canvas){


    }
}
