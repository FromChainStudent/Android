package com.example.listtwo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ListView lv_left, lv_right;
    private List<String> list_left, list_right;
    private LeftAdapter adapter;
    private PopupWindow pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop);

        loadData();

//        btn = (Button) findViewById(R.id.btn);
//
//        pop = new PopupWindow();
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (pop.isShowing()){
//                    pop.dismiss();
//                    Toast.makeText(MainActivity.this, "消失了", Toast.LENGTH_SHORT).show();
//                } else {
//                    initPop();
//                }
//            }
//        });

        lv_left = (ListView) findViewById(R.id.lv_left);
        lv_right = (ListView) findViewById(R.id.lv_right);
        adapter = new LeftAdapter();
        lv_left.setAdapter(adapter);
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list_right.clear();
                lv_right.setAdapter(new RightAdapter());
            }
        });
    }

    private void initPop() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop, null);
        pop.setContentView(view);
        pop.setFocusable(false);
        pop.setBackgroundDrawable(null);
        pop.setOutsideTouchable(false);
        pop.setWidth(R.layout.pop);
        pop.setHeight(R.layout.pop);
        pop.showAsDropDown(btn);
        lv_left = (ListView) view.findViewById(R.id.lv_left);
        lv_right = (ListView) view.findViewById(R.id.lv_right);
        adapter = new LeftAdapter();
        lv_left.setAdapter(adapter);
        Toast.makeText(MainActivity.this, "弹出了", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "adapter:" + adapter);
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list_right.clear();
                lv_right.setAdapter(new RightAdapter());
            }
        });
    }

    private void loadData() {
        list_left = new ArrayList<>();
        list_left.add("热门分类");
        list_left.add("美食");
        list_left.add("购物");
        list_left.add("休闲娱乐");
        list_left.add("运动瘦身");
        list_left.add("丽人");
        list_left.add("结婚");
        list_left.add("酒店");
        list_left.add("爱车");
        list_left.add("亲子");
        list_right = new ArrayList<>();
        list_right.add("全部分类");
        list_right.add("小吃快餐");
        list_right.add("咖啡厅");
        list_right.add("电影院");
        list_right.add("KTV");
        list_right.add("茶馆");
        list_right.add("足疗按摩");
        list_right.add("超市/便利店");
        list_right.add("银行");
        list_right.add("经济型酒店");
    }

    class LeftAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list_left.isEmpty() ? 0 : list_left.size();
        }

        @Override
        public Object getItem(int position) {
            return list_left.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText(list_left.get(position));
            tv.setHeight(150);
            tv.setTextColor(Color.GREEN);
            Log.d("LeftAdapter", tv.getText().toString());
            return tv;
        }
    }

    class RightAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list_right.isEmpty() ? 0 : list_right.size();
        }

        @Override
        public Object getItem(int position) {
            return list_right.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText(list_right.get(position));
            tv.setHeight(150);
            tv.setTextColor(Color.RED);
            return tv;
        }
    }
}
