package edu.niu.cs.z1693760.fitnessapp; // heyyyy more red -once again SDK platform or something

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        HomeFragment.OnFragmentInteractionListener, DataFragment.OnFragmentInteractionListener, GoalsFragment.OnFragmentInteractionListener, StartWorkoutFragment.OnFragmentInteractionListener,
ResumeWorkoutFragment.OnFragmentInteractionListener, StartExerciseFragment.OnFragmentInteractionListener, ResumeExerciseFragment.OnFragmentInteractionListener{

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navView;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Make changes to the toolbar
        toolbar.setPadding(10, 10, 10, 10);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        // Change color of the status bar - the grey was ugly and I couldn't figure out how to do it otherwise
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        if (savedInstanceState == null) {

            Fragment fragment = null;
            Class fragmentClass = null;
            fragmentClass = HomeFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*navView = (NavigationView) findViewById(R.id.nav_view);

        setupDrawerContent(navView);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle() + "pressed", Toast.LENGTH_LONG).show();
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });*/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.home_fragment) {
            fragmentClass = HomeFragment.class;
            //Toast.makeText(getApplicationContext(), "This is my data", Toast.LENGTH_LONG).show();
        } else if (id == R.id.data_fragment) {
            fragmentClass = DataFragment.class;
        } else if (id == R.id.goals_fragment) {
            fragmentClass = GoalsFragment.class;
        } else if (id == R.id.start_workout_fragment) {
            fragmentClass = StartWorkoutFragment.class;
        } else if (id == R.id.resume_workout_fragment) {
            fragmentClass = ResumeWorkoutFragment.class;
        } else if (id == R.id.start_exercise_fragment) {
            fragmentClass = StartExerciseFragment.class;
        } else if (id == R.id.resume_exercise_fragment) {
            fragmentClass = ResumeExerciseFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

