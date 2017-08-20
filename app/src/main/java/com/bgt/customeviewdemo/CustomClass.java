package com.bgt.customeviewdemo;

import android.graphics.drawable.Drawable;

/**
 * Created by Bhavesh on 20-08-2017.
 */

public class CustomClass {

    private String title;
    private Drawable drawable;
    private Drawable selectedDrawable;

    public CustomClass(String title, Drawable drawable,Drawable selectedDrawable) {
        this.title = title;
        this.drawable = drawable;
        this.selectedDrawable = selectedDrawable;
    }

    public Drawable getSelectedDrawable() {
        return selectedDrawable;
    }

    public void setSelectedDrawable(Drawable selectedDrawable) {
        this.selectedDrawable = selectedDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
