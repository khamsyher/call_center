package com.example.call_center;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.call_center.adapter.adt_rv_Main;
import com.google.android.material.tabs.TabLayout;

public class fm_main extends Fragment {



    public fm_main() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fm_main, container, false);
        final TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        final ViewPager vpMain = (ViewPager) v.findViewById(R.id.vpMain);
        adt_rv_Main adt=new adt_rv_Main(getChildFragmentManager());
        vpMain.setAdapter(adt);
        tabLayout.setupWithViewPager(vpMain);
        return v;
    }
}