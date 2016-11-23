package com.demo.personomics.personomics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

/**
 * Created by umeshkhanna on 2016-11-23.
 */

public class EmailActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_email);

        int height = 500;

        getActionBar().hide();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int)(width * 0.8), height);
    }

    public void closeName (View view) {
        Intent i = new Intent();
        i.putExtra("email", ((EditText)findViewById(R.id.email)).getText().toString());
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
