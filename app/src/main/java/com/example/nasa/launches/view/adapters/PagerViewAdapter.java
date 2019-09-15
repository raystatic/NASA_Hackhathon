package com.example.nasa.launches.view.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.nasa.launches.view.fragments.PastFragment;
import com.example.nasa.launches.view.fragments.UpcomingFragment;

public class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new UpcomingFragment();
            case 1:
                return new PastFragment();
//            case 2:
//                return new NotificationFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}
