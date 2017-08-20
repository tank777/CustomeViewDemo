package com.bgt.customeviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavesh on 20-08-2017.
 */

public class MainActivityRecycle extends AppCompatActivity {
    @BindView(R.id.rl)
    RecyclerView rl;
    RecycleAdapter recycleAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycle);
        ButterKnife.bind(this);

        List<CustomClass> dataList = new ArrayList<CustomClass>();
        dataList.add(new CustomClass("Camera", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_camera)));
        dataList.add(new CustomClass("Gallery", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_camera)));
        dataList.add(new CustomClass("Emoji", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_camera)));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        rl.setLayoutManager(gridLayoutManager);
        recycleAdapter = new RecycleAdapter(getApplicationContext(),dataList);
        rl.setAdapter(recycleAdapter);
    }
}
