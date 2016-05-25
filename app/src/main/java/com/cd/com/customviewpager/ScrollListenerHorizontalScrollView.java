package com.cd.com.customviewpager;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class ScrollListenerHorizontalScrollView extends HorizontalScrollView {

    public ScrollListenerHorizontalScrollView(Context context,
                                              AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public ScrollListenerHorizontalScrollView(Context context,
                                              AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public ScrollListenerHorizontalScrollView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        scrollChangeListener.scrollChanged(l, t, oldl, oldt);
    }
    ScrollChangeListener scrollChangeListener;

    public void setOnScrollListener(ScrollChangeListener scrollChangeListener) {
        this.scrollChangeListener = scrollChangeListener;
    }
    public interface ScrollChangeListener {
        void  scrollChanged(int l, int t, int oldl, int oldt);

    }


}