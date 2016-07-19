package com.zwei.materialdesigndemo.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zwei.materialdesigndemo.service.ApiSupport;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/11.
 */

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {


    private ArrayList<Activity> activityList = new ArrayList<Activity>();


    @Override
    public void onCreate() {
        super.onCreate();

        ApiSupport.initReft(this);
        this.registerActivityLifecycleCallbacks(this);


    }





    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

    public Activity getActivityByName(String name){

        for (Activity temp:activityList){
            if (temp.getClass().getName().equals(name)){
                return temp;
            }
        }
        return null;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        try {
            activityList.add(activity);
            System.out.println("add:" + activity.getClass().getName());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    @Override
    public void onActivityStarted(Activity activity) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onActivityResumed(Activity activity) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onActivityPaused(Activity activity) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onActivityStopped(Activity activity) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onActivityDestroyed(Activity activity) {
        try {
            activityList.remove(activity);
            System.out.println("remove:" + activity.getClass().getName());
            if (activityList.size() == 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {
        System.out.println("========");
        System.out.println("test:" + activityList.size());
        System.out.println("========");

    }


}