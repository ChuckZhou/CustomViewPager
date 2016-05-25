package com.cd.com.customviewpager;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager customVPager;
    private int[] imgRes;
    private LinearLayout hsv_ll;
    int moveY = 60;
    private boolean isOne;
    private int centerDis;
    private ScrollListenerHorizontalScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgRes = new int[]{R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d,
                R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.i};
        customVPager = (ViewPager) findViewById(R.id.custom_vp);
        customVPager.setPageMargin(50);
        customVPager.setOffscreenPageLimit(5);
        customVPager.setAdapter(new VpgaerAdapter());
        int type = getIntent().getIntExtra("type", 0);
        switch(type){
            case 0:
                customVPager.setPageTransformer(true ,new RotationPageTransformer());
                break;
            case 1:
                customVPager.setPageTransformer(true ,new ScalePageTransformer());
                break;
            case 2:
                customVPager.setPageTransformer(true ,new AlphaPageTransformer());
                break;
            case 3:
                customVPager.setPageTransformer(true ,new UpDownMovePageTransformer());
                break;
            case 4:
                isOne = true;
                findViewById(R.id.fl).setVisibility(View.GONE);
                break;

        }
       if(type!=4)return;
        scrollView = (ScrollListenerHorizontalScrollView) findViewById(R.id.hsv);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //一共可以横向移动的距离
        int moveDis = displayMetrics.widthPixels;
        centerDis = moveDis / 2;
        hsv_ll = (LinearLayout) findViewById(R.id.hsv_ll);
        for (int i = 0; i < imgRes.length; i++) {
            ImageView view = new ImageView(this);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
//          view.setBackgroundColor(Color.parseColor("#44ff0000"));
            view.setImageResource(imgRes[i]);
            hsv_ll.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = 350;
            layoutParams.width = 200;
            if (i < imgRes.length - 1) {
                layoutParams.rightMargin = 20;
            }
            view.setLayoutParams(layoutParams);
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (isOne && hasFocus) {
            int childCount = hsv_ll.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = hsv_ll.getChildAt(i);
                int[] locations = new int[2];
                view.getLocationOnScreen(locations);
                int locationX = locations[0] + 100;
                int viewCenterDis = Math.abs(centerDis - locationX);//view中心距离 屏幕中心X轴的距离
                int moveHeight = (viewCenterDis * moveY / centerDis);
                view.setTranslationY(moveHeight);
            }
            scrollView.setOnScrollListener(new ScrollListenerHorizontalScrollView.ScrollChangeListener() {
                @Override
                public void scrollChanged(int l, int t, int oldl, int oldt) {
                    int childCount = hsv_ll.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View view = hsv_ll.getChildAt(i);
                        int[] locations = new int[2];
                        view.getLocationOnScreen(locations);
                        int locationX = locations[0] + 100;
                        int viewCenterDis = Math.abs(centerDis - locationX);//view中心距离 屏幕中心X轴的距离
                        int moveHeight = (viewCenterDis * moveY / centerDis);
                        view.setTranslationY(moveHeight);
                    }
                }
            });
        }
        super.onWindowFocusChanged(hasFocus);
    }

    class VpgaerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = new ImageView(MainActivity.this);
            view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//            view.setBackgroundColor(Color.parseColor("#44ff0000"));
            view.setImageResource(imgRes[position]);
            container.addView(view);
//           view.setAdjustViewBounds(true);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return imgRes.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }

}