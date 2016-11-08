package com.demo.personomics.personomics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * Created by umeshkhanna on 2016-11-07.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActionBar().hide();
    }

    public void launchSignUp (View view) {
        Intent i = new Intent(SplashActivity.this, PopupActivity.class);
        i.putExtra("signup", true);
        startActivity(i);
    }

    public void launchLogin (View v) {
        Intent i = new Intent(SplashActivity.this, PopupActivity.class);
        i.putExtra("signup", false);
        startActivity(i);
    }
}
