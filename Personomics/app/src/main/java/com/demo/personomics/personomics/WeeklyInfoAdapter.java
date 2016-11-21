package com.demo.personomics.personomics;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class WeeklyInfoAdapter extends RecyclerView.Adapter<WeeklyInfoAdapter.MyViewHolder> {

    private Context mContext;
    private List<WeekInfo> weekInfoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, value, unit;
        public BarChart barChart;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            value = (TextView) itemView.findViewById(R.id.value);
            unit = (TextView) itemView.findViewById(R.id.unit);
            barChart = (BarChart) itemView.findViewById(R.id.bar_chart);
        }
    }

    public WeeklyInfoAdapter(Context mContext, List<WeekInfo> weekInfoList) {
        this.mContext = mContext;
        this.weekInfoList = weekInfoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_weekly, parent, false);
        return new WeeklyInfoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeeklyInfoAdapter.MyViewHolder holder, int position) {
        WeekInfo weekInfo = weekInfoList.get(position);
        holder.name.setText(weekInfo.getName());
        holder.value.setText(String.valueOf(weekInfo.getValue()));
        holder.unit.setText(weekInfo.getUnits());
        BarChart bc = holder.barChart;

        bc.setOnChartValueSelectedListener(null);
        bc.setData(generateData(weekInfo));
        bc.setDrawBarShadow(false);
        bc.setDrawValueAboveBar(false);
        bc.getDescription().setEnabled(false);

        bc.getAxisLeft().setEnabled(false);
        bc.getAxisRight().setEnabled(false);

        bc.getXAxis().setEnabled(false);
        bc.setDrawGridBackground(false);
        bc.setTouchEnabled(true);
        bc.getLegend().setEnabled(false);

    }

    @Override
    public int getItemCount() {return weekInfoList.size();}

    private BarData generateData(WeekInfo weekInfo) {

        ArrayList<BarEntry> yvals1 = new ArrayList<>();

        for (int i = 0; i < 7 ; ++i) {
            yvals1.add(new BarEntry(i, weekInfo.getInfo().get(i)));
        }

        BarDataSet set1;
        set1 = new BarDataSet(yvals1, "title");
        set1.setColor(0xff74429B);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        data.setBarWidth(0.5f);
        data.setValueTextSize(0f);

        return data;
    }
}
