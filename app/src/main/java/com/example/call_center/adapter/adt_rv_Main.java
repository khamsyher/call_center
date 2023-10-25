package com.example.call_center.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.call_center.fm_emergency;
import com.example.call_center.fm_help;
import com.example.call_center.fm_request;

public class adt_rv_Main extends FragmentPagerAdapter {
    public adt_rv_Main(@NonNull FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fm_emergency();
            case 1:
                return new fm_help();
            case 2:
                return new fm_request();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Emergency";
            case 1:
                return "Help me";
            case 2:
                return "Request";
        }
        return null;
    }
}
