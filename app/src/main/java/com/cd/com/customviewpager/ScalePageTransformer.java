package com.cd.com.customviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2016/5/12.
 */
public class ScalePageTransformer implements ViewPager.PageTransformer {

    private static final float DEFAULT_SCALE = 0.8F;
    private float scale = DEFAULT_SCALE;

    public ScalePageTransformer() {
    }

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        page.setPivotY(pageHeight / 2);
        page.setPivotX(pageWidth / 2);
              if(position<-1){
                  page.setScaleX(scale);
                  page.setScaleY(scale);
              }else if(position<=1){
                 if (position<=0){
                  float scaleXY=scale+(1-scale)*(1+position);
                     page.setScaleX(scaleXY);
                     page.setScaleY(scaleXY);
                 }else{
                     float scaleXY=scale+(1-scale)*(1-position);
                     page.setScaleX(scaleXY);
                     page.setScaleY(scaleXY);
                 }
              }else{
                  page.setScaleX(scale);
                  page.setScaleY(scale);
              }

    }
}
