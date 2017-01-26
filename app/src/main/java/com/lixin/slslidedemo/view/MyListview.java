package com.lixin.slslidedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Created by lixin on 2017/1/18.
 */

public class MyListview extends ListView {


    public MyListview(Context context) {
        this(context, null);
    }

    public MyListview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    /**
     * 改listview滑到底端了
     *
     * @return
     */
    public boolean isBottom() {
        int firstVisibleItem = getFirstVisiblePosition();//屏幕上显示的第一条是list中的第几条
        int childcount = getChildCount();//屏幕上显示多少条item
        int totalItemCount = getCount();//一共有多少条
        if ((firstVisibleItem + childcount) >=totalItemCount) {
            return true;
        }
        return false;
    }

    /**
     * 改listview在顶端
     *
     * @return
     */
    public boolean isTop() {
        int firstVisibleItem = getFirstVisiblePosition();
        if (getChildAt(firstVisibleItem) != null && getChildAt(firstVisibleItem).getTop() == 0) {
            return true;
        }
        return false;
    }

    float down = 0;
    float y;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                down = event.getRawY();

                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                y = event.getRawY();
                if (isTop()) {
                    if (y - down > 1) {
//                        到顶端,向下滑动  把事件拦截 由自己处理
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        //   到顶端,向上滑动 把事件教给父类
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }

                if (isBottom()) {
                    if (y - down > 1) {
//                        到底端,向下滑动  把事件教给父类
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
//                        到底端,向上滑动 把事件拦截 由自己处理
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }


    /**
     * 停止滑动
     */
    public  void stopScroll() {
        try {
            Field flingEndField = AbsListView.class.getDeclaredField("mFlingRunnable" );
            flingEndField.setAccessible(true);
            Method flingEndMethod = flingEndField .getType().getDeclaredMethod("endFling");
            flingEndMethod.setAccessible(true);
            flingEndMethod.invoke(flingEndField.get(this));
        } catch (Exception e) {
        }
    }


}
