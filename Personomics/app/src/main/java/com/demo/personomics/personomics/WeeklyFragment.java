package com.demo.personomics.personomics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class WeeklyFragment extends Fragment {

    RecyclerView mRecyclerView;
    WeeklyInfoAdapter mWeeklyInfoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_weekly, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        final List<WeekInfo> weekInfoList= generateWeekInfo();
        mWeeklyInfoAdapter = new WeeklyInfoAdapter(getContext(), weekInfoList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mWeeklyInfoAdapter);

        return rootView;
    }

    private  List<WeekInfo> generateWeekInfo() {
        List<WeekInfo> weekInfoList = new ArrayList<>();
        ArrayList<Integer> info = new ArrayList<>();
        info.add(4);
        info.add(3);
        info.add(5);
        info.add(8);
        info.add(2);
        info.add(1);
        info.add(6);
        weekInfoList.add(new WeekInfo("Active Time", 123, "hours", info));
        return weekInfoList;
    }
}
