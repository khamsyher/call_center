package com.example.call_center;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class fm_aboutme extends Fragment {

    public fm_aboutme() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fm_aboutme, container, false);
        String url = "file://android_asset/aboutme.html";
        WebView wv = (WebView) v.findViewById(R.id.wvAboutMe);
        wv.getSettings().setJavaScriptEnabled(true);
        return v;

    }
}