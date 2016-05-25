package com.cd.com.customviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2016/5/24.
 */
public class UpDownMovePageTransformer implements ViewPager.PageTransformer {
    float tranLength=30;
    float yTran=0;
    @Override
    public void transformPage(View page, float position) {
        //-1 0  1对应左边 中间 右边
//        if (position < -1) {
//            page.setTranslationY(tranLength);
//        } else if (position <= 1) {
//            if (position <= 0) {
//                yTran = -tranLength * position;
//            } else {
//                yTran = tranLength * position;
//            }
//            page.setTranslationY(yTran);
//        } else {
//            page.setTranslationY(tranLength);
//        }
        if (position < -2) {
            page.setTranslationY(tranLength*2);
        } else if (position <= 2) {
            if (position <= 0) {
                yTran = -tranLength * position;
            } else {
                yTran = tranLength * position;
            }
            page.setTranslationY(yTran);
        } else {
            page.setTranslationY(tranLength*2);
        }

    }
}
