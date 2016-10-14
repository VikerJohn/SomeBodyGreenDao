package com.example.dsw.cardviewdemo.wedigt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.dsw.cardviewdemo.R;


/**
 * 弧形进度条
 *
 * @author Eric
 */
public class ArcProgressbar2 extends View {

    private float bgStrokeWidth = 30;
    private float barStrokeWidth = bgStrokeWidth - 3;
    private int bgColor = Color.GRAY;
    private int barColor = Color.RED;
    private int smallBgColor = Color.WHITE;
    private int progress = 50;
    private int progressMax = 100;
    private int startAngle = 200;
    private int endAngle = 140;
    private Paint mPaintBar = null;
    private Paint mPaintSmallBg = null;
    private Paint mPaintBg = null;
    private Paint mPaintMainBg = null;
    private RectF rectBg = null;


    private boolean showSmallBg = true;// 是否显示小背景。
    private float endAngle2;

    public ArcProgressbar2(Context context) {
        super(context, null);
    }

    public ArcProgressbar2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initProgressbar(context, attrs, 0);
    }

    public ArcProgressbar2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initProgressbar(context, attrs, defStyleAttr);
    }


    private void initProgressbar(Context context, AttributeSet attrs, int defStyle) {
        TypedArray attributes = context.obtainStyledAttributes(attrs,  R.styleable.ArcProgressbar, defStyle, 0);

        progress = attributes.getInt(R.styleable.ArcProgressbar_progress_, 50);
        progressMax = attributes.getInt(R.styleable.ArcProgressbar_progressMax, 100);
        bgStrokeWidth = attributes.getDimension(R.styleable.ArcProgressbar_bgStrokeWidth, 30);
        barStrokeWidth = attributes.getDimension(R.styleable.ArcProgressbar_barStrokeWidth, 27);
        bgColor = attributes.getColor(R.styleable.ArcProgressbar_bgColor, getResources().getColor(R.color.arcProgressbar_bgColor));
        smallBgColor = attributes.getColor(R.styleable.ArcProgressbar_smallBgColor, getResources().getColor(R.color.main_bg));
        barColor = attributes.getColor(R.styleable.ArcProgressbar_barColor, getResources().getColor(R.color.m_green));


        // 大弧形背景画笔。
        mPaintBg = new Paint();
        mPaintBg.setAntiAlias(true);
        mPaintBg.setStyle(Style.STROKE);
        mPaintBg.setStrokeWidth(bgStrokeWidth);
        mPaintBg.setColor(bgColor);
        mPaintBg.setStrokeCap(Paint.Cap.ROUND);//设置为圆角

        //小弧形背景画笔。
        mPaintSmallBg = new Paint();
        mPaintSmallBg.setAntiAlias(true);
        mPaintSmallBg.setStyle(Style.STROKE);
        mPaintSmallBg.setStrokeWidth(barStrokeWidth);
        mPaintSmallBg.setColor(smallBgColor);
        mPaintSmallBg.setStrokeCap(Paint.Cap.ROUND);//设置为圆角

        //进度画笔
        mPaintBar = new Paint();
        mPaintBar.setAntiAlias(true);
        mPaintBar.setStyle(Style.STROKE);
        mPaintBar.setStrokeWidth(barStrokeWidth);
        mPaintBar.setColor(barColor);
        mPaintBar.setStrokeCap(Paint.Cap.ROUND);//设置为圆角

        mPaintMainBg = new Paint();
        mPaintMainBg.setColor(getResources().getColor(R.color.white));
        mPaintMainBg.setStyle(Style.FILL); //设置空心
        mPaintMainBg.setAntiAlias(true);  //消除锯齿


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init(canvas);

    }

    int rectTop = 30;
    int rectLeft = 15;
    int rectRitht = 0;
    int rectBottom = 0;

    private void init(Canvas canvas) {

        rectRitht = getWidth() - rectLeft;
        rectBottom = getHeight();
        rectBg = new RectF(rectLeft, rectTop, rectRitht, rectBottom);

        //控件背景
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaintMainBg);// 长方形

        //进度条背景
        drawBg(canvas);

        // 弧形ProgressBar。
        canvas.drawArc(rectBg, startAngle, endAngle * progress / progressMax, false, mPaintBar);


    }

    private void drawBg(Canvas canvas) {

        canvas.drawArc(rectBg, startAngle, endAngle, false, mPaintBg);
        // 弧形小背景。
        if (showSmallBg) {
            canvas.drawArc(rectBg, startAngle, endAngle, false, mPaintSmallBg);
        }
    }

    /**
     * @param _progress
     */
    public void addProgress(int _progress) {
        progress = _progress;
        if (progress > progressMax)
            progress=100;

        invalidate();
    }

    /**
     * 设置弧形背景的画笔宽度。
     */
    public void setBgStrokeWidth(int bgStrokeWidth) {
        this.bgStrokeWidth = bgStrokeWidth;
    }

    /**
     * 设置弧形ProgressBar的画笔宽度。
     */
    public void setBarStrokeWidth(int barStrokeWidth) {
        this.barStrokeWidth = barStrokeWidth;
    }

    /**
     * 设置弧形背景的颜色。
     */
    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    /**
     * 设置弧形ProgressBar的颜色。
     */
    public void setBarColor(int barColor) {
        this.barColor = barColor;
    }

    /**
     * 设置弧形小背景的颜色。
     */
    public void setSmallBgColor(int smallBgColor) {
        this.smallBgColor = smallBgColor;
    }



    /**
     * 是否显示小背景。
     */
    public void setShowSmallBg(boolean showSmallBg) {
        this.showSmallBg = showSmallBg;
    }


}

