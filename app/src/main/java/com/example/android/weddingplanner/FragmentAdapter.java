package com.example.android.weddingplanner;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Elesdody on 04-Apr-18.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private Context context;
    public FragmentAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0)
            return new HallsFragment();
        else if (position==1)
            return new BeautyFragment();
        else if (position==2)
            return new SuitsFragment();
        else if (position==3)
            return new PhotographerFragment();
        else
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position ==0)
            return "Halls";
        else if (position==1)
            return "Beatuy";
        else if (position==2)
            return "Suits";
        else if (position==3)
            return "Photographer";
        else
            return null;
    }
}
