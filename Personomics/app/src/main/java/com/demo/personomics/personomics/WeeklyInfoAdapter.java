package com.demo.personomics.personomics;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class WeeklyInfoAdapter extends RecyclerView.Adapter<WeeklyInfoAdapter.MyViewHolder> {

    private Context mContext;
    private List<WeekInfo> weekInfoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, value, unit, bottom;
        public LineChart lineChart;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            value = (TextView) itemView.findViewById(R.id.value);
            unit = (TextView) itemView.findViewById(R.id.unit);
            bottom = (TextView) itemView.findViewById(R.id.bottom);
            lineChart = (LineChart) itemView.findViewById(R.id.line_chart);
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
        if (weekInfo.getName().equals("Blood Pressure")) holder.bottom.setVisibility(View.VISIBLE);
        holder.value.setText(String.valueOf(weekInfo.getValue()));
        holder.unit.setText(weekInfo.getUnits());
        LineChart lc = holder.lineChart;

        lc.setId(R.id.line_chart);

        lc.setData(generateData(weekInfo));
        lc.getAxisRight().setEnabled(false);
        lc.getLegend().setEnabled(false);
        lc.setDrawGridBackground(false);
        lc.getDescription().setEnabled(false);
        lc.getXAxis().setEnabled(false);
        lc.getAxisLeft().setEnabled(false);
        lc.setTouchEnabled(false);
    }

    @Override
    public int getItemCount() {return weekInfoList.size();}

    private LineData generateData(WeekInfo weekInfo) {
        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < 7; i++) {
            values.add(new Entry(i, weekInfo.getInfo().get(i)));
        }

        LineDataSet set1;

        // create a dataset and give it a type
        set1 = new LineDataSet(values, "DataSet 1");

        // set the line to be drawn like this "- - - - - -"

        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(0f);
        set1.setDrawFilled(true);
        set1.setFormLineWidth(1f);
        set1.setFormSize(15.f);

        // fill drawable only supported on api level 18 and above
        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.fade_purple);
        set1.setFillDrawable(drawable);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(dataSets);

        // set data
        return data;
    }
}
