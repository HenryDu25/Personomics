package com.demo.personomics.personomics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by umeshkhanna on 2016-11-08.
 */

public class NumberActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_confirmation);

        int height = 500;

        getActionBar().hide();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        getWindow().setLayout((int)(width * 0.8), height);
    }

    public void closeConfirm (View v) {
        finish();
    }
}
