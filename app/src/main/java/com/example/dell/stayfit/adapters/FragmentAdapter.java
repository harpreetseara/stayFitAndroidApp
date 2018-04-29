package com.example.dell.stayfit.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dell.stayfit.fragments.Frag1;
import com.example.dell.stayfit.fragments.Frag2;
import com.example.dell.stayfit.fragments.Frag3;

/**
 * Created by Dell on 4/29/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return (new Frag1());
        else if (position == 1)
            return (new Frag2());
        else if (position == 2)
            return (new Frag3());
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "Activities";
        else if (position == 1)
            return "Diet Plans";
        else if (position == 2)
            return "Exercises";
        return super.getPageTitle(position);
    }
}
