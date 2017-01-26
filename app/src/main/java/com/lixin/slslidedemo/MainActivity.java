package com.lixin.slslidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

import com.lixin.slslidedemo.adapter.ListviewAdapter;
import com.lixin.slslidedemo.view.MyListview;

public class MainActivity extends AppCompatActivity {
    ScrollView myScrollView;
    MyListview myListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        myListview = (MyListview) findViewById(R.id.listview);
        myScrollView = (ScrollView) findViewById(R.id.scrollView);
        myListview.setAdapter(new ListviewAdapter(this));
    }




}
