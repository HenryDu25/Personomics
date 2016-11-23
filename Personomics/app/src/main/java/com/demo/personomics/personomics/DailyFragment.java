package com.demo.personomics.personomics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-17.
 */

public class DailyFragment extends Fragment {

    RecyclerView mRecyclerViewHealth;
    ProgressAdapter mProgressAdapterHealth;

    RecyclerView mRecyclerViewFitness;
    RecipeAdapter mRecipeAdapter;

    TextView timer;
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
        final List<Recipe> recipeList = RecipeFragment.generateRecipes();
        mRecipeAdapter = new RecipeAdapter(getContext(), recipeList);
        mRecyclerViewFitness.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewFitness.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerViewFitness ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                int itemPosition = mRecyclerViewFitness.getChildLayoutPosition(view);
                String item = recipeList.get(itemPosition).getUrl();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item));
                startActivity(browserIntent);
            }

            @Override public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));
        mRecyclerViewFitness.setAdapter(mRecipeAdapter);

        rootView.findViewById(R.id.recycler_view_health).setVisibility(View.VISIBLE);
        rootView.findViewById(R.id.recycler_view_fitness).setVisibility(View.GONE);

        timer = (TextView) rootView.findViewById(R.id.time);

        new CountDownTimer(40200000, 1000) {

            public void onTick(long x) {
                long h = x / (60*60*1000);
                x = x - h*(60*60*1000);
                long m = x / (60*1000);
                x = x - m*(60*1000);
                long s = x / 1000;
                x = x - s*1000;
                timer.setText(h + "hours " + m + " minutes " + s + " seconds");
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                timer.setText("Now!");
            }

        }.start();

        return rootView;
    }

    private List<Progress> generateProgressHealth() {
        List<Progress> progressList = new ArrayList<>();

        progressList.add(new Progress("B12", 3.1, 5, "ng"));
        progressList.add(new Progress("D", 4.7, 6, "ng"));
        progressList.add(new Progress("Iron", 5.4, 8, "ng"));
        progressList.add(new Progress("Calcium", 6.4, 8, "ng"));
        progressList.add(new Progress("Magnesium", 4.4, 11, "ng"));
        progressList.add(new Progress("Iodine", 1, 3, "ng"));
        progressList.add(new Progress("C", 5.4, 6, "ng"));

        return progressList;
    }
}
