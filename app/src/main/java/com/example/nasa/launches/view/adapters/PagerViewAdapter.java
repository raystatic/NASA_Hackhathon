package com.example.nasa.launches.view.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.nasa.HomeActivity;
import com.example.nasa.launches.view.fragments.PastFragment;
import com.example.nasa.launches.view.fragments.UpcomingFragment;

public class PagerViewAdapter extends FragmentPagerAdapter {

    HomeActivity homeActivity;
    public PagerViewAdapter(FragmentManager fm, HomeActivity homeActivity) {
        super(fm);
        this.homeActivity=homeActivity;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new UpcomingFragment(homeActivity);
            case 1:
                return new PastFragment(homeActivity);
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
