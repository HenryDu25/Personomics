package com.demo.personomics.personomics;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.tabhost;

/**
 * Created by umeshkhanna on 2016-11-18.
 */

public class ProfileFragment extends Fragment
    implements ViewPager.OnPageChangeListener
        , TabHost.OnTabChangeListener {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ViewPager mPager;
    private TabHost mTabHost;

    private PagerAdapter mPagerAdapter;

    public static ProfileFragment newInstance(int sectionNumber) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        ((TextView) rootView.findViewById(R.id.personName)).setText(((HomeActivity) getActivity()).name);
        initPager(rootView);
        initTabHost(rootView);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }

    private void initTabHost(View v) {

        mTabHost = (TabHost) v.findViewById(tabhost);
        mTabHost.setup();

        String[] tabNames = {"Daily", "Weekly","Monthly"};

        for (int i = 0; i < tabNames.length;++i) {
            TabHost.TabSpec tabSpec;
            tabSpec = mTabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new TabContent(getActivity()));
            mTabHost.addTab(tabSpec);
        }

        mTabHost.setOnTabChangedListener(this);
    }

    private void initPager (View v) {

        List<android.support.v4.app.Fragment> fl = new ArrayList<>();
        fl.add(new DailyFragment());
        fl.add(new WeeklyFragment());
        fl.add(new MonthlyFragment());

        mPager = (ViewPager) v.findViewById(R.id.pager);
        mPagerAdapter = new ProfilePagerAdapter(getChildFragmentManager(), fl);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(this);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String s) {
        int selectedPage = mTabHost.getCurrentTab();
        mPager.setCurrentItem(selectedPage);
    }
}