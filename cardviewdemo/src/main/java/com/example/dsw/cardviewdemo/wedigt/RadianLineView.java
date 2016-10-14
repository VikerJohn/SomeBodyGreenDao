package com.example.dsw.cardviewdemo.wedigt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.dsw.cardviewdemo.R;


/**
 * Created by Administrator on 2016/9/23.
 */

public class RadianLineView extends View {
    private boolean isFill;
    private int rvColor;

    public RadianLineView(Context context) {
        super(context);
    }

    public RadianLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs,0);
    }



    public RadianLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs,int defStyleAttr) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.RadianLineView, defStyleAttr, 0);


        isFill = attributes.getBoolean(R.styleable.RadianLineView_zIsFill, false);
        rvColor = attributes.getColor(R.styleable.RadianLineView_zRvColor, getResources().getColor(R.color.white));


        attributes.recycle();


    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(rvColor);
        if (isFill) {
            paint.setStyle(Paint.Style.FILL);//设置填满
        } else {
            paint.setStyle(Paint.Style.STROKE); //设置空心
        }

        paint.setAntiAlias(true);  //消除锯齿


        RectF oval = new RectF(-20, 0, getWidth() + 20, getHeight());
        canvas.drawArc(oval, 180, 180, false, paint);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);//设置填满
        canvas.drawRect(0, getHeight() / 2, getWidth(), getHeight(), paint);// 长方形

    }
}
