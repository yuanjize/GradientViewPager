package viewpager.demo.com.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by yjz on 2015/11/10.
 */
public class MyPageTransformer implements ViewPager.PageTransformer {
    private int pageWidth;

    MyPageTransformer(int pageWidth) {
        this.pageWidth = pageWidth;
    }

    @Override
    public void transformPage(View page, float position) {

        if (position <= -1) {
            page.setAlpha(0);
        } else if (position <= 0) {
            //出去的页面,慢慢变大，越来越透明
            page.setTranslationX(pageWidth * (-position));
            page.setAlpha(1 - Math.abs(position));
            page.setScaleX(Math.abs(1 + Math.abs(position)));
            page.setScaleY(Math.abs(1 + Math.abs(position)));
        } else if (position <= 1) {
            //进来的页面,慢慢变小，越来越不透明
            page.setTranslationX(pageWidth * (-position));
            page.setAlpha(1 - Math.abs(position));
            page.setScaleX(Math.abs(1 + position));
            page.setScaleY(Math.abs(1 + position));
        } else {

        }
    }


}

