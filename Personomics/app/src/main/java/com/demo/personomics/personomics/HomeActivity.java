package com.demo.personomics.personomics;

import android.app.Activity;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.pdf.PdfRenderer;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.net.Uri;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

public class HomeActivity extends android.support.v4.app.FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        DatePickerDialog.OnDateSetListener{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;


    public List<LineChart> lineChartList;
    public int lineChartCounter;
    public String name;
    public String email;
    public String location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.mainPurple)));

        name = "Umesh Khanna";
        email = "Umesh.Khanna@gmail.com";
        location = "Toronto";

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        lineChartList = new ArrayList<>();
        lineChartCounter = 2;

        Intent i = new Intent(HomeActivity.this, NumberActivity.class);
        startActivity(i);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (position == 0) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, ProfileFragment.newInstance(position + 1))
                    .commit();
        } else if (position == 1) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, MicrobiomeFragment
                            .newInstance(position + 1))
                    .commit();
        }else if (position == 2) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, RecipeFragment.newInstance(position + 1))
                    .commit();
        } else if (position == 3) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, LiveChatFragment.newInstance(position + 1))
                    .commit();
        } else if (position == 4) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PartnerFragment.newInstance(position + 1))
                    .commit();
        } else if (position == 5) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, SettingsFragment.newInstance(position + 1))
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = "Profile";
                break;
            case 2:
                mTitle = "Learn Your Microbiome";
                break;
            case 3:
                mTitle = "Recipes";
                break;
            case 4:
                mTitle = "Live Chat";
                break;
            case 5:
                mTitle = "Partners";
                break;
            case 6:
                mTitle = "Settings";
                break;

        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            //getMenuInflater().inflate(R.menu.home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((HomeActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public void toggleDaily(View v) {
        if (v.findViewById(R.id.health) != null) {
            findViewById(R.id.health).setBackground(new ColorDrawable(Color.parseColor("#CCCCCC")));
            findViewById(R.id.fitness).setBackground(new ColorDrawable(Color.parseColor("#EEEEEE")));
            findViewById(R.id.checkin).setBackground(new ColorDrawable(Color.parseColor("#EEEEEE")));

            findViewById(R.id.recycler_view_health).setVisibility(View.VISIBLE);
            findViewById(R.id.recycler_view_fitness).setVisibility(View.GONE);
        } else if (v.findViewById(R.id.fitness) != null) {
            findViewById(R.id.health).setBackground(new ColorDrawable(Color.parseColor("#EEEEEE")));
            findViewById(R.id.fitness).setBackground(new ColorDrawable(Color.parseColor("#CCCCCC")));
            findViewById(R.id.checkin).setBackground(new ColorDrawable(Color.parseColor("#EEEEEE")));

            findViewById(R.id.recycler_view_health).setVisibility(View.GONE);
            findViewById(R.id.recycler_view_fitness).setVisibility(View.VISIBLE);
        } else if (v.findViewById(R.id.checkin) != null) {
            findViewById(R.id.health).setBackground(new ColorDrawable(Color.parseColor("#EEEEEE")));
            findViewById(R.id.fitness).setBackground(new ColorDrawable(Color.parseColor("#EEEEEE")));
            findViewById(R.id.checkin).setBackground(new ColorDrawable(Color.parseColor("#CCCCCC")));

            findViewById(R.id.recycler_view_health).setVisibility(View.GONE);
            findViewById(R.id.recycler_view_fitness).setVisibility(View.GONE);
        }
    }

    public void lastMonth (View v) {
        if (lineChartCounter != 0) {
            --lineChartCounter;
            if (lineChartCounter == 0) {
                ((TextView)findViewById(R.id.month)).setText("September");
                ViewGroupUtils.replaceView(findViewById(R.id.line_chart), lineChartList.get(lineChartCounter));
            } else if (lineChartCounter == 1) {
                ((TextView)findViewById(R.id.month)).setText("October");
                ViewGroupUtils.replaceView(findViewById(R.id.line_chart), lineChartList.get(lineChartCounter));
            }
        }
    }

    public void nextMonth (View v) {
        if (lineChartCounter != 2) {
            ++lineChartCounter;
            if (lineChartCounter == 1) {
                ((TextView)findViewById(R.id.month)).setText("October");
                ViewGroupUtils.replaceView(findViewById(R.id.line_chart), lineChartList.get(lineChartCounter));
            } else if (lineChartCounter == 2) {
                ((TextView)findViewById(R.id.month)).setText("November");
                ViewGroupUtils.replaceView(findViewById(R.id.line_chart), lineChartList.get(lineChartCounter));
            }
        }
    }

    public void updateName (View view) {
        Intent i = new Intent(HomeActivity.this, NameActivity.class);
        startActivityForResult(i, 0);
    }

    public void updateEmail (View view) {
        Intent i = new Intent(HomeActivity.this, EmailActivity.class);
        startActivityForResult(i, 1);
    }

    public void updateLocation (View view) {
        Intent i = new Intent(HomeActivity.this, LocationActivity.class);
        startActivityForResult(i, 2);
    }

    public void updatePassword (View view) {
        Intent i = new Intent(HomeActivity.this, PasswordActivity.class);
        startActivity(i);
    }

    public void updateBirthday (View view) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        DatePickerDialog dialog = new DatePickerDialog(HomeActivity.this, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;

        if (requestCode == 0) {
            name = data.getStringExtra("name");
            ((TextView) findViewById(R.id.personName)).setText(data.getStringExtra("name"));
        } if (requestCode == 1) {
            email = data.getStringExtra("email");
            ((TextView) findViewById(R.id.email)).setText(data.getStringExtra("email"));
        } if (requestCode == 2) {
            location = data.getStringExtra("location");
            ((TextView) findViewById(R.id.location)).setText(data.getStringExtra("location"));
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        ((TextView) findViewById(R.id.birth)).setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(month + 1).append("/").append(day).append("/").append(year).append(" "));
    }

    public void openLink(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.multiplylabs.com/#/"));
        startActivity(browserIntent);
    }

    public void notYetToast (View view) {
        Toast.makeText(this, "Your appointment has not started yet.",
                Toast.LENGTH_SHORT).show();
    }
}