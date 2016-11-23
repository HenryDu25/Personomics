package com.demo.personomics.personomics;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-18.
 */

public class RecipeFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    RecyclerView mRecyclerView;
    RecipeAdapter mRecipeAdapter;

    public static RecipeFragment newInstance(int sectionNumber) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public RecipeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        final List<Recipe> recipeList = generateRecipes();
        mRecipeAdapter = new RecipeAdapter(getContext(), recipeList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                int itemPosition = mRecyclerView.getChildLayoutPosition(view);
                String item = recipeList.get(itemPosition).getUrl();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item));
                startActivity(browserIntent);
            }

            @Override public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));
        mRecyclerView.setAdapter(mRecipeAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }

    public static List<Recipe> generateRecipes () {
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Umesh", R.drawable.breakfast, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh1", R.drawable.lunch, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh2", R.drawable.dinner, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh3", R.drawable.snack, "http://www.google.com"));
        return recipeList;
    }
}
