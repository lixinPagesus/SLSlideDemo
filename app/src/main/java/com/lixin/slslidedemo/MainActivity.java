package com.lixin.slslidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
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


        myListview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i){
                    case SCROLL_STATE_IDLE:
                        //滑动停止时调用
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        //正在滚动时调用

                        break;
                    case SCROLL_STATE_FLING:
                        //手指快速滑动时,在离开ListView由于惯性滑动
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                int lastVisibleItem = myListview.getLastVisiblePosition();
                if (i == 5  || lastVisibleItem == 5) {
                    if(!myListview.isIntercept){
                        myListview.stopScroll();
                    }

                }

            }
        });


    }




}
