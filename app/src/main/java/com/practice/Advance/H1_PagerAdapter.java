package com.practice.Advance;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by Lenovo on 07/08/2018.
 */

public class H1_PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public H1_PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                H1_tab1 tab1 = new H1_tab1();
                return tab1;
            case 1:
                H1_tab2 tab2 = new H1_tab2();
                return tab2;
            case 2:
                H1_tab3 tab3 = new H1_tab3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

