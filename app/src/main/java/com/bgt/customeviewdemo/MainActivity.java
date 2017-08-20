package com.bgt.customeviewdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_item);
        ButterKnife.bind(this);
        int initSelectedPosition = 3;
        List<CustomClass> dataList = new ArrayList<CustomClass>();
        dataList.add(new CustomClass("Camera", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_camera)));
        dataList.add(new CustomClass("Gallery", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_camera)));
        dataList.add(new CustomClass("Emoji", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_camera)));

        TestAdapter adapter = new TestAdapter(MainActivity.this, dataList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setItemChecked(initSelectedPosition, true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 選択状態を要素(checkable)へ反映
                Checkable child = (Checkable) parent.getChildAt(position);
                child.toggle();
            }
        });
    }

    private static class TestAdapter extends ArrayAdapter<CustomClass> {

       private Context context;
        public TestAdapter(Context context, List<CustomClass> dataList) {
            super(context, 0, dataList);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = ((AppCompatActivity)context).getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_view, parent, false);
                holder = new ViewHolder();
                //holder.text = (TextView) convertView.findViewById(R.id.text);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            // bindData

            return convertView;
        }
    }

    private static class ViewHolder {

    }
}
