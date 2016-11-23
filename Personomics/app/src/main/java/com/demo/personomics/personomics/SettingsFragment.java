package com.demo.personomics.personomics;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.tabhost;

/**
 * Created by umeshkhanna on 2016-11-22.
 */

public class SettingsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static SettingsFragment newInstance(int sectionNumber) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        ((TextView) rootView.findViewById(R.id.personName)).setText(((HomeActivity) getActivity()).name);
        ((TextView) rootView.findViewById(R.id.email)).setText(((HomeActivity) getActivity()).email);
        ((TextView) rootView.findViewById(R.id.location)).setText(((HomeActivity) getActivity()).location);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).onSectionAttached(this.getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
