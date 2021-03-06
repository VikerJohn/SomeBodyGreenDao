package com.zwei.materialdesigndemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zwei.materialdesigndemo.fragment.EmojiViewFragment;
import com.zwei.materialdesigndemo.fragment.ItemFragment;
import com.zwei.materialdesigndemo.fragment.PhotoGrideFragment;
import com.zwei.materialdesigndemo.fragment.PlaceholderFragment;
import com.zwei.materialdesigndemo.fragment.ViewPagerFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);

        switch (position) {
            case 0:
                return new ViewPagerFragment();
            case 1:
                return new ItemFragment();
            case 2:
                return new PhotoGrideFragment();
            case 3:
                return new EmojiViewFragment();

            default:
                return PlaceholderFragment.newInstance(position + 1);
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return "外加";
    }
}