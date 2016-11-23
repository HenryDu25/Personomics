package com.demo.personomics.personomics;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {

    private Context mContext;
    private List<Recipe> recipeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;

        public MyViewHolder(View view) {
            super(view);
            picture = (ImageView) view.findViewById(R.id.recipe_picture);
        }
    }

    public RecipeAdapter(Context mContext, List<Recipe> recipeList) {
        this.mContext = mContext;
        this.recipeList = recipeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_recipie, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (final MyViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.picture.setImageResource(recipe.getPicNum());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
