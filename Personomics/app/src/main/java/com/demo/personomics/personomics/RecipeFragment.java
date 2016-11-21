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

    RecyclerView mRecyclerView;
    RecipeAdapter mRecipeAdapter;

    public static RecipeFragment newInstance() {
        RecipeFragment fragment = new RecipeFragment();
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

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
        ((HomeActivity) activity).onSectionAttached(3);
    }

    public List<Recipe> generateRecipes () {
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Umesh", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh1", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh2", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh3", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh4", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh5", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh6", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh7", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh8", R.drawable.umesh, "http://www.google.com"));
        recipeList.add(new Recipe("Umesh9", R.drawable.umesh, "http://www.google.com"));
        return recipeList;
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
