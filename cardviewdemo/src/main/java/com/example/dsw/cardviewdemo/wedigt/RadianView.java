package com.example.dsw.cardviewdemo.wedigt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.dsw.cardviewdemo.R;


/**
 * Created by Administrator on 2016/9/23.
 */

public class RadianView extends View {
    public RadianView(Context context) {
        super(context);
    }

    public RadianView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RadianView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(getResources().getColor(R.color.white));
        paint.setStyle(Paint.Style.FILL); //设置空心
        paint.setAntiAlias(true);  //消除锯齿



        RectF oval = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawArc(oval, 180, 180, false, paint);

//        paint.setColor(Color.GRAY);// 设置灰色
//        paint.setStyle(Paint.Style.FILL);//设置填满
        canvas.drawRect(0, getHeight() / 2, getWidth(), getHeight(), paint);// 长方形

    }
}
