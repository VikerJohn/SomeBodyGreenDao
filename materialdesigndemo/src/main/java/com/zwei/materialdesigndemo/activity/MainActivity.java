package com.zwei.materialdesigndemo.activity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.adapter.SectionsPagerAdapter;
import com.zwei.materialdesigndemo.utils.ABViewUtil;
import com.zwei.materialdesigndemo.widget.RevealView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private RevealView mAlbumRevealView;
    private boolean mIsAlbumRevealOpen =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAlbumRevealColorView(getLocationInView(mAlbumRevealView,view));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });


        mAlbumRevealView = (RevealView) findViewById(R.id.reveal_album);
        mAlbumRevealView.setOnTouchListener(mEmptyTouch);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,

                R.string.app_name,
                R.string.hello_blank_fragment);


        toggle. setDrawerIndicatorEnabled(false);
//        toggle.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * 计算坐标
     *
     * @param src
     * @param target
     * @return
     */
    public Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }


    /**
     * floatingActionButton打开的时候不能点击后面的gridview
     */
    private View.OnTouchListener mEmptyTouch = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (v.getId() == R.id.reveal_album) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Point point = new Point((int) event.getX(), (int) event.getY());
//                    mFloatingActionsMenu.collapse(false);
                    hideAlbumRevealColorView(point);
                }
            }
            return true;
        }
    };

    /**
     * 隐藏RevealColorView
     *
     * @param p
     */
    private void hideAlbumRevealColorView(Point p) {
        mAlbumRevealView.hide(p.x, p.y, Color.TRANSPARENT, 0, 1000, null);
        mIsAlbumRevealOpen = false;
    }

    /**
     * 显示RevealColorView
     *
     * @param p
     */
    private void showAlbumRevealColorView(Point p) {

        mAlbumRevealView.reveal(p.x, p.y, ABViewUtil.getColor(this,R.color.fab_reveal_white), 10, 1000, null);
        mIsAlbumRevealOpen = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
