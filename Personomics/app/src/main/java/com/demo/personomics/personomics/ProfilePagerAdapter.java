package com.demo.personomics.personomics;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-18.
 */

public class ProfilePagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;

    public ProfilePagerAdapter(FragmentManager fm,
                               List<android.support.v4.app.Fragment> fl) {
        super(fm);
        this.fragmentList = fl;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}