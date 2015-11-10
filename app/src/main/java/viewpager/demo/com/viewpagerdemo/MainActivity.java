package viewpager.demo.com.viewpagerdemo;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ViewPager pages;
    private List<View> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int width = getResources().getDisplayMetrics().widthPixels;
        list.add(View.inflate(this, R.layout.item_layout, null));
        list.add(View.inflate(this, R.layout.item_layout2, null));
        list.add(View.inflate(this, R.layout.item_layout3, null));

        pages = (ViewPager) findViewById(R.id.pages);
        pages.setAdapter(new MyAdpater());
        pages.setPageTransformer(true, new MyPageTransformer(width));
    }

    class MyAdpater extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(list.get(position));
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
