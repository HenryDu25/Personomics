package com.demo.personomics.personomics;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class MonthlyFragment extends Fragment {

    List<LineChart> lineChartList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_monthly, container, false);

        lineChartList = ((HomeActivity) getActivity()).lineChartList;

        for (int i = 0; i < 3 ; ++i) {
            LineChart lc;
            if (i == 2) lc = (LineChart) rootView.findViewById(R.id.line_chart);
            else lc = new LineChart(getContext());
            lc.setId(R.id.line_chart);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f);
            params.setMargins(0,0,0,64);
            lc.setLayoutParams(params);
            lc.setData(setData(31, 100));
            lc.getAxisRight().setEnabled(false);
            lc.getLegend().setEnabled(false);
            lc.setDrawGridBackground(false);
            lc.getDescription().setEnabled(false);
            lc.getXAxis().setEnabled(false);
            lc.setTouchEnabled(false);
            lineChartList.add(lc);
        }

        return rootView;
    }

    private LineData setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {

            float val = (float) (Math.random() * range) + 3;
            values.add(new Entry(i, val));
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
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_purple);
        set1.setFillDrawable(drawable);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(dataSets);

        // set data
        return data;
    }

}