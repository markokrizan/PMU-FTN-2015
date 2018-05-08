package com.example.freeman.projekat.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.freeman.projekat.fragments.ReadPostTabFragment;

/**
 * Created by Freeman on 5/8/2018.
 */

public class ReadPostPagerAdapter extends FragmentPagerAdapter {

    private String title[] = {"Objava", "Komentari"};

    public ReadPostPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return ReadPostTabFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}