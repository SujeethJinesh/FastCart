package com.example.admin.fastcart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

/**
 * Created by aayush on 9/10/16.
 */
public class CarouselMaster extends FragmentActivity {
    static ViewPager viewPager = null;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carousel);

        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        myAdapter = new MyAdapter(fragmentManager);
        viewPager.setAdapter(myAdapter);
    }

    public static void moveToGallery() {
        viewPager.setCurrentItem(0);
    }

    public static void moveToPurchase() {
        viewPager.setCurrentItem(2);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            Fragment fragment = null;


            if (i == 0)
            {
                fragment = new Gallery();
            }
            if (i == 1)
            {
                fragment = new OutfitSelector();
            }
            if (i == 2)
            {
                fragment = new Purchase();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
