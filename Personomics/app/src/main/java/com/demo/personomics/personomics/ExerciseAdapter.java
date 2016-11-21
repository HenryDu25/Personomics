package com.demo.personomics.personomics;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyViewHolder> {

    private Context mContext;
    private List<Exercise> exerciseList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView icon;
        public TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.icon = (ImageView) itemView.findViewById(R.id.icon);
            this.description = (TextView) itemView.findViewById(R.id.description);
        }
    }

    public ExerciseAdapter(Context mContext, List<Exercise> exerciseList) {
        this.mContext = mContext;
        this.exerciseList = exerciseList;
    }

    @Override
    public ExerciseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_exercise, parent, false);
        return new ExerciseAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExerciseAdapter.MyViewHolder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        holder.name.setText(exercise.getName());
        holder.icon.setImageResource(exercise.getIcon());
        holder.description.setText(exercise.getDescription());
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}
