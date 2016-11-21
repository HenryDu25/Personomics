package com.demo.personomics.personomics;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.MyViewHolder>{

    private Context mContext;
    private List<Progress> progressList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ProgressBar progressBar;
        public TextView progress;
        public TextView units;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            this.progress = (TextView) itemView.findViewById(R.id.progress);
            this.units = (TextView) itemView.findViewById(R.id.unit);
        }
    }

    public ProgressAdapter(Context mContext, List<Progress> progressList) {
        this.mContext = mContext;
        this.progressList = progressList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_progress, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Progress progress = progressList.get(position);
        holder.name.setText(progress.getName());
        holder.progressBar.setProgress((int) (100 * (progress.getProgressVal()/ progress.getProgressGoal())));
        holder.progress.setText(String.valueOf(progress.getProgressVal()));
        holder.units.setText(progress.getUnits());
    }

    @Override
    public int getItemCount() {return progressList.size();}
}
