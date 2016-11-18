package com.demo.personomics.personomics;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/**
 * Created by umeshkhanna on 2016-11-18.
 */

public class TabContent implements TabHost.TabContentFactory {
    Context context;

    public TabContent(Context context) {
        this.context = context;
    }

    @Override
    public View createTabContent(String tag) {
        View tabView = new View(context);
        tabView.setMinimumHeight(0);
        tabView.setMinimumWidth(0);
        return tabView;
    }
}