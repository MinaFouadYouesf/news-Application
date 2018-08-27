package com.example.mina.newstoday.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class startPagerTabsAdapter  extends FragmentPagerAdapter{


    public startPagerTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
         if (position == 0)
            return new genral();
        if (position == 1)
            return new science();
        if (position == 2)
            return new sports();
        if (position == 3)
            return new technology();
        if (position == 4)
            return new Business();
        if (position == 5)
            return new Entertainment();
        if (position == 6) {
            return new  health();
        }
             return null;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }


}
