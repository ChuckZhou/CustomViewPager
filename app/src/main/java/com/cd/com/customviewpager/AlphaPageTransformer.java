package com.cd.com.customviewpager;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2016/5/11.
 */
public class AlphaPageTransformer implements ViewPager.PageTransformer {

    final static float DEFAULT_ALPHA=0.15F;
    private float minAlpha=DEFAULT_ALPHA;

    public AlphaPageTransformer() {
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void transformPage(View page, float position) {
          if (position<-1){
              page.setAlpha(minAlpha);
          }else if (position<=1){
             if (position<=0){
                 float alpha=minAlpha+(1-minAlpha)*(1+position);
                page.setAlpha(alpha);
             }else{
              float alpha=minAlpha+(1-minAlpha)*(1-position);
                 page.setAlpha(alpha);
             }
          }else{
              page.setAlpha(minAlpha);
          }





    }
}
