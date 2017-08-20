package com.bgt.customeviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavesh on 20-08-2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private Context context;
    private List<CustomClass> dataList;

    public RecycleAdapter(Context context, List<CustomClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CustomClass customClass = dataList.get(position);
        holder.customView.setTvTitle(customClass.getTitle());
        holder.customView.setIvImage(customClass.getDrawable());
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.custom_view)
        CustomView customView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
