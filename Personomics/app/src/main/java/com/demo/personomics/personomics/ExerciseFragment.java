package com.demo.personomics.personomics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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

public class ExerciseFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    RecyclerView mRecyclerView;
    ExerciseAdapter mExerciseAdapter;

    public static ExerciseFragment newInstance(int sectionNumber) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ExerciseFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mExerciseAdapter = new ExerciseAdapter(getContext(), generateExerciseList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mExerciseAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).onSectionAttached(2);
    }

    private List<Exercise> generateExerciseList () {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("Jump Rope", R.drawable.jumprope, "Jump with both feet slightly apart over the rope."));
        exerciseList.add(new Exercise("Jogging", R.drawable.jog, "Jogging is a form of trotting or running at a slow or leisurely pace."));
        exerciseList.add(new Exercise("Stretching", R.drawable.stretch, "Stretching is a form of physical exercise in which a specific muscle or tendon (or muscle group) is deliberately flexed or stretched in order to improve the muscle's felt elasticity and achieve comfortable muscle tone."));

        return exerciseList;
    }

}
