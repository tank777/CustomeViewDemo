package com.bgt.customeviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavesh on 19-08-2017.
 */

public class CustomView extends RelativeLayout {

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;

    public CustomView(@NonNull Context context) {
        this(context, null);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.custome_view, this);
        ButterKnife.bind(this);
        setPadding(SizeUtils.convertDpToPixel(context, 5), 0, SizeUtils.convertDpToPixel(context, 5), 0);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        int iconResId = a.getResourceId(R.styleable.CustomView_view_icon, 0);
        String title = a.getString(R.styleable.CustomView_view_title);
        a.recycle();

        if (iconResId == 0) {
            ivImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_action_camera));
        } else {
            ivImage.setImageResource(iconResId);
        }

        tvTitle.setText(title != null ? title : "");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setTvTitle(String title) {
        tvTitle.setText(title);
    }

    public void setIvImage(Drawable drawable) {
        ivImage.setImageDrawable(drawable);
    }

    public void setSelectedIvImage(Drawable selectedIvImage)
    {
        ivImage.setImageDrawable(selectedIvImage);
    }

    public void selectLayout() {
        frameLayout.setSelected(true);
    }

    public void unselectedLayout() {
        frameLayout.setSelected(false);
    }
}
