package com.cd.com.customviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2016/5/12.
 */
public class RotationPageTransformer implements ViewPager.PageTransformer {

    private  static final float DEFAULT_ROTATION=15f;
    private float rotation=DEFAULT_ROTATION;
    public RotationPageTransformer() {

    }

    @Override
    public void transformPage(View page, float position) {
        int pageWidth= page.getWidth();
        int pageHeight=page.getHeight();

        if (position<-1){
            page.setPivotX(pageWidth);
            page.setRotation(rotation);
        }else if (position<=1){
            if (position<=0){
                page.setPivotX(pageWidth);
                float rorationY=rotation-(1+position)*rotation;
                page.setRotation(rorationY);
            }else{
                page.setPivotX(0);
                float rorationY=rotation-(1-position)*rotation;
                page.setRotation(-rorationY);
            }
        }else {
            page.setPivotX(0);
            page.setRotation(-rotation);
       }

    }
}
