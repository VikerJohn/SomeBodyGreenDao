package com.zwei.materialdesigndemo.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.fragment.ContentFragment;
import com.zwei.materialdesigndemo.fragment.ScrollViewFragment;
import com.zwei.materialdesigndemo.fragment.ViewPagerFragment;

public class DraScrollActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentManager fm;
    private DrawerLayout drawer;


//    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);

        //设置半透明的底色
//        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));


        setContentView(R.layout.activity_dra_scroll);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        View v = findViewById(R.id.rl_content);

        fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();
        ContentFragment mWeixin = new ContentFragment();
        transaction.replace(R.id.rl_content, mWeixin);
        transaction.commit();

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public DrawerLayout getDrawer() {
        return drawer;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dra_scroll, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            fm = getSupportFragmentManager();

            FragmentTransaction transaction = fm.beginTransaction();
            ContentFragment mWeixin = new ContentFragment();
            transaction.replace(R.id.rl_content, mWeixin);
            transaction.commit();
        } else if (id == R.id.nav_gallery) {
            FragmentTransaction transaction = fm.beginTransaction();
            ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
            transaction.replace(R.id.rl_content, viewPagerFragment);
            transaction.commit();
        } else if (id == R.id.nav_slideshow) {
            FragmentTransaction transaction = fm.beginTransaction();
            Fragment fragment = new ScrollViewFragment();
            transaction.replace(R.id.rl_content, fragment);
            transaction.commit();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
