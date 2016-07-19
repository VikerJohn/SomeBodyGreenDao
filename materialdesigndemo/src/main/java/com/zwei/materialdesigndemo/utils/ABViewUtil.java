package com.zwei.materialdesigndemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zwei.materialdesigndemo.R;

import java.util.List;

/**
 * Date: 14-4-3
 * Time: 下午1:47
 */
public class ABViewUtil {

    /**
     * 适用于Adapter中简化ViewHolder相关代码
     *
     * @param convertView
     * @param id
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends View> T obtainView(View convertView, int id) {
        SparseArray<View> holder = (SparseArray<View>) convertView.getTag();
        if (holder == null) {
            holder = new SparseArray<View>();
            convertView.setTag(holder);
        }
        View childView = holder.get(id);
        if (childView == null) {
            childView = convertView.findViewById(id);
            holder.put(id, childView);
        }
        return (T) childView;
    }


    /**
     * view设置background drawable
     * 兼容低版本
     *
     * @param view
     * @param drawable
     */
    @SuppressLint("NewApi")
    public static void setBackgroundDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }


    public static int getColor(Context mContext, int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
           return mContext.getColor(resId);
        } else {
           return mContext.getResources().getColor(resId);
        }
    }


    /**
     * 获取控件的高度，如果获取的高度为0，则重新计算尺寸后再返回高度
     *
     * @param view
     * @return
     */
    public static int getViewMeasuredHeight(View view) {
//        int height = view.getMeasuredHeight();
//        if(0 < height){
//            return height;
//        }
        calcViewMeasure(view);
        return view.getMeasuredHeight();
    }

    /**
     * 获取控件的宽度，如果获取的宽度为0，则重新计算尺寸后再返回宽度
     *
     * @param view
     * @return
     */
    public static int getViewMeasuredWidth(View view) {
//        int width = view.getMeasuredWidth();
//        if(0 < width){
//            return width;
//        }
        calcViewMeasure(view);
        return view.getMeasuredWidth();
    }

    /**
     * 控件X轴坐标
     *
     * @param v
     * @return
     */
    public static int getLocationOnScreenX(View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        return x;
    }

    /**
     * 控件Y轴坐标
     *
     * @param v
     * @return
     */
    public static int getLocationOnScreenY(View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        return y;
    }

    /**
     * 测量控件的尺寸
     *
     * @param view
     */
    public static void calcViewMeasure(View view) {
//        int width = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
//        int height = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
//        view.measure(width,height);

        int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        view.measure(width, expandSpec);
    }

 /*   public static int getAllListViewSectionCounts(ListView lv, List dataSource) {
        if (null == lv || ABTextUtil.isEmpty(dataSource)) {
            return 0;
        }
        return dataSource.size() + lv.getHeaderViewsCount() + lv.getFooterViewsCount();
    }*/

    /**
     * 使用ColorFilter来改变亮度
     *
     * @param imageview
     * @param brightness
     */
    public static void changeBrightness(ImageView imageview, float brightness) {
        imageview.setColorFilter(getBrightnessMatrixColorFilter(brightness));
    }

    public static void changeBrightness(Drawable drawable, float brightness) {
        drawable.setColorFilter(getBrightnessMatrixColorFilter(brightness));
    }

    private static ColorMatrixColorFilter getBrightnessMatrixColorFilter(float brightness) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.set(
                new float[]{
                        1, 0, 0, 0, brightness,
                        0, 1, 0, 0, brightness,
                        0, 0, 1, 0, brightness,
                        0, 0, 0, 1, 0
                });
        return new ColorMatrixColorFilter(matrix);
    }

    /**
     * 动态设置ListView的高度
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    //使用Bitmap加Matrix来缩放
    public static Drawable resizeImage(Bitmap bitmap, int w, int h) {
        Bitmap BitmapOrg = bitmap;
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = w;
        int newHeight = h;

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // if you want to rotate the Bitmap
        // matrix.postRotate(45);
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
                height, matrix, true);
        return new BitmapDrawable(resizedBitmap);
    }

    //使用BitmapFactory.Options的inSampleSize参数来缩放
    public static Drawable resizeImage2(String path,
                                        int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//不加载bitmap到内存中
        BitmapFactory.decodeFile(path, options);
        int outWidth = options.outWidth;
        int outHeight = options.outHeight;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = 1;

        if (outWidth != 0 && outHeight != 0 && width != 0 && height != 0) {
            int sampleSize = (outWidth / width + outHeight / height) / 2;
            options.inSampleSize = sampleSize;
        }

        options.inJustDecodeBounds = false;
        return new BitmapDrawable(BitmapFactory.decodeFile(path, options));
    }

    /**
     * 按比例放大bitmap
     *
     * @param bitmap
     * @return
     */
    public static Bitmap big(Bitmap bitmap) {
     /*   Matrix matrix = new Matrix();
        matrix.postScale(1.5f,1.5f); //长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);*/
        return ScaleBitmap(bitmap, 1.5f, 1.5f);
    }

    /**
     * 按比例缩小bitmap
     *
     * @param bitmap
     * @return
     */
    public static Bitmap small(Bitmap bitmap) {
        /*Matrix matrix = new Matrix();
        matrix.postScale(0.8f,0.8f); //长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);*/
        return ScaleBitmap(bitmap, 0.8f, 0.8f);
    }

    /**
     * 按比例缩放bitmap,
     *
     * @param bitmap
     * @param x      缩放比例
     * @param y      缩放比例
     * @return
     */
    public static Bitmap ScaleBitmap(Bitmap bitmap, float x, float y) {
        Matrix matrix = new Matrix();
        matrix.postScale(x, y); //长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizeBmp;
    }

    public static int getWindowsHeight(Context context) {

        /*WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();*/
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
//        int height = dm.heightPixels;
        return dm.heightPixels;
    }

}