package com.zwei.materialdesigndemo.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.zwei.materialdesigndemo.R;
import com.zwei.materialdesigndemo.fragment.ContentFragment;
import com.zwei.materialdesigndemo.fragment.NewActionBarFragment;

public class NewActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_new_action_bar);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        NewActionBarFragment fragment = new NewActionBarFragment();
        transaction.replace(R.id.root, fragment);
        transaction.commit();

    }
}
