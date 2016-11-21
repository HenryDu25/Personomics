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
 * Created by umeshkhanna on 2016-11-17.
 */

public class DailyFragment extends Fragment {

    RecyclerView mRecyclerViewHealth;
    ProgressAdapter mProgressAdapterHealth;

    RecyclerView mRecyclerViewFitness;
    ProgressAdapter mProgressAdapterFitness;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_daily, container, false);

        mRecyclerViewHealth = (RecyclerView) rootView.findViewById(R.id.recycler_view_health);
        final List<Progress> progressListHealth = generateProgressHealth();
        mProgressAdapterHealth = new ProgressAdapter(getContext(), progressListHealth);
        mRecyclerViewHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewHealth.setAdapter(mProgressAdapterHealth);

        mRecyclerViewFitness = (RecyclerView) rootView.findViewById(R.id.recycler_view_fitness);
        final List<Progress> progressListFitness = generateProgressFitness();
        mProgressAdapterFitness = new ProgressAdapter(getContext(), progressListFitness);
        mRecyclerViewFitness.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewFitness.setAdapter(mProgressAdapterFitness);

        rootView.findViewById(R.id.recycler_view_health).setVisibility(View.VISIBLE);
        rootView.findViewById(R.id.recycler_view_fitness).setVisibility(View.GONE);

        return rootView;
    }

    private List<Progress> generateProgressHealth() {
        List<Progress> progressList = new ArrayList<>();

        progressList.add(new Progress("B12", 3.1, 5, "ng"));
        progressList.add(new Progress("D", 4.7, 6, "ng"));
        progressList.add(new Progress("Iron", 5.4, 8, "ng"));

        return progressList;
    }

    private List<Progress> generateProgressFitness() {
        List<Progress> progressList = new ArrayList<>();

        progressList.add(new Progress("Push Ups", 10, 10, "reps"));
        progressList.add(new Progress("Run", 5, 10, "km"));
        progressList.add(new Progress("Skip Rope", 30, 100, "jumps"));
        progressList.add(new Progress("Badminton", 2, 3, "hours"));

        return progressList;
    }

}
