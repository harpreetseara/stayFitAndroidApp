package com.example.dell.stayfit.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.dell.stayfit.adapters.FragmentAdapter;
import com.example.dell.stayfit.R;
import com.example.dell.stayfit.diaglogs.AboutAppDialog;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabs;
    DrawerLayout mDrawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) (findViewById(R.id.toolbar));
        tabs = (TabLayout) (findViewById(R.id.tabs));
        pager = (ViewPager) (findViewById(R.id.pager));
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);


        setupTabs();
        setupToolbar();
        setupNavigationDrawer();
    }

    private void setupTabs() {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);

    }

    private void setupToolbar() {

        setSupportActionBar(toolbar);
        toolbar.setTitle("STAY FIT");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener
                (
                        new NavigationView.OnNavigationItemSelectedListener() {
                            // This method will trigger on item Click of navigation menu
                            @Override
                            public boolean onNavigationItemSelected(MenuItem menuItem) {

                                if (menuItem.getItemId() == R.id.action_history) {
                                    startActivity(new Intent(getApplicationContext(), SessionHistory.class));
                                } else if (menuItem.getItemId() == R.id.action_aboutapp) {
                                    startActivity(new Intent(getApplicationContext(), AboutAppDialog.class));
                                }


                                //Logic
                                mDrawerLayout.closeDrawers();
                                return true;
                            }
                        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

}
