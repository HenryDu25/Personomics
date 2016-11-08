package com.demo.personomics.personomics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by umeshkhanna on 2016-11-07.
 */

public class PopupActivity extends Activity  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_login);

        int height = 880;

        if (getIntent().getBooleanExtra("signup", false)) {
            findViewById(R.id.confirm).setVisibility(View.VISIBLE);
            ((Button)findViewById(R.id.signInButton)).setText("sign up");
            height = 1040;
        }

        getActionBar().hide();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int)(width * 0.8), height);
    }

    public void launchHome (View v) {
        startActivity(new Intent(PopupActivity.this, HomeActivity.class));
    }
}
