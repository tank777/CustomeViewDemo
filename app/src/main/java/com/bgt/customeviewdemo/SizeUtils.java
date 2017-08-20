package com.bgt.customeviewdemo;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class SizeUtils {


    private static WindowManager windowManager;

    private static WindowManager getWindowManager(Context context){
        if(windowManager == null){
            windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }

        return windowManager;
    }

    public static int getScreenWidth(Context c){
        WindowManager wm = getWindowManager(c);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.x;
    }

    public static int getScreenHeight(Context c){
        WindowManager wm = getWindowManager(c);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.y;
    }

    public static int convertDpToPixel(Context context,float dp){

        return (int) (dp * ((float)getDisplayMetrics(context).densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int convertPixelsToDp(Context context, float px){
        return (int) (px / ((float)getDisplayMetrics(context).densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static DisplayMetrics getDisplayMetrics(Context ctx) {
        DisplayMetrics dm = new DisplayMetrics();

        WindowManager wm = getWindowManager(ctx);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(dm);

        return dm;
    }

}
