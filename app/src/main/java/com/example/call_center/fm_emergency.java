package com.example.call_center;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.call_center.adapter.adt_rv_Emergency;


public class fm_emergency extends Fragment {
    Context ctx;
    RecyclerView rv;
    adt_rv_Emergency adt;
    public fm_emergency(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fm_emergency, container, false);
        ctx = container.getContext();
        rv = (RecyclerView) v.findViewById(R.id.recyle_view);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(ctx);
        rv.setLayoutManager(lm);
        adt = new adt_rv_Emergency();
        rv.setAdapter(adt);
        return v;
    }
}