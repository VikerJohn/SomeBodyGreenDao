package com.zwei.somebodygreendao;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.Random;

/**
 * Created by Administrator on 2016/5/30.
 */
public class NickeToBitmapUtil {

    private static NickeToBitmapUtil bmpCode;

    public static NickeToBitmapUtil getInstance() {
        if (bmpCode == null)
            bmpCode = new NickeToBitmapUtil();
        return bmpCode;
    }

    //default settings
    private static final int DEFAULT_CODE_LENGTH = 4;
    private static final int DEFAULT_FONT_SIZE = 27;
    private static final int DEFAULT_LINE_NUMBER = 2;
    private static final int BASE_PADDING_LEFT = 10, RANGE_PADDING_LEFT = 15, BASE_PADDING_TOP = 15, RANGE_PADDING_TOP = 20;
    private static final int DEFAULT_WIDTH = 100, DEFAULT_HEIGHT = 40;

    //settings decided by the layout xml
    //canvas width and height
    private int width = DEFAULT_WIDTH, height = DEFAULT_HEIGHT;

    //random word space and pading_top
    private int base_padding_left = BASE_PADDING_LEFT, range_padding_left = RANGE_PADDING_LEFT,
            base_padding_top = BASE_PADDING_TOP, range_padding_top = RANGE_PADDING_TOP;

    //number of chars, lines; font size
    private int codeLength = DEFAULT_CODE_LENGTH, line_number = DEFAULT_LINE_NUMBER, font_size = DEFAULT_FONT_SIZE;

    //variables
    private String nickeName;
    private int padding_left, padding_top;
    private Random random = new Random();

    public Bitmap createBitmap(String nickeName) {
        padding_left = 0;
        nickeName = "@"+nickeName+":";
        width = nickeName.length() * 17 ;
        Log.d("NickeToBitmapUtil", "nickeName::" + nickeName.length());
        Log.d("NickeToBitmapUtil", width + ":::width");

        Bitmap bp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bp);

//        nickeName = createCode();


        c.drawColor(Color.TRANSPARENT);
        Paint paint = new Paint();
        paint.setTextSize(font_size);

/*        for (int i = 0; i < nickeName.length(); i++) {
            randomTextStyle(paint);
            randomPadding();
            c.drawText(nickeName.charAt(i) + "", base_padding_left, base_padding_top, paint);
        }*/
//        paint.setColor();
        c.drawText(nickeName, 10, 25, paint);

/*        for (int i = 0; i < line_number; i++) {
            drawLine(c, paint);
        }*/

        c.save(Canvas.ALL_SAVE_FLAG);//保存
        c.restore();//
        return bp;
    }

    public String getNickeName() {
        return nickeName;
    }


    private int randomColor() {
        return randomColor(1);
    }

    private int randomColor(int rate) {
        int red = random.nextInt(256) / rate;
        int green = random.nextInt(256) / rate;
        int blue = random.nextInt(256) / rate;
        return Color.rgb(red, green, blue);
    }

    private void randomTextStyle(Paint paint) {
        int color = randomColor();
        paint.setColor(color);
        paint.setFakeBoldText(random.nextBoolean());  //true为粗体，false为非粗体
        float skewX = random.nextInt(11) / 10;
        skewX = random.nextBoolean() ? skewX : -skewX;
        paint.setTextSkewX(skewX); //float类型参数，负数表示右斜，整数左斜
//      paint.setUnderlineText(true); //true为下划线，false为非下划线
//      paint.setStrikeThruText(true); //true为删除线，false为非删除线
    }

    private void randomPadding() {
        padding_left += base_padding_left + random.nextInt(range_padding_left);
        padding_top = base_padding_top + random.nextInt(range_padding_top);
    }
}
