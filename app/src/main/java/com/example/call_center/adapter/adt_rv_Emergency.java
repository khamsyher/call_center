package com.example.call_center.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.call_center.R;
import com.example.call_center.model.CallNumber;

import java.util.ArrayList;
import java.util.List;

public class adt_rv_Emergency extends RecyclerView.Adapter<adt_rv_Emergency.ViewHolder> {
    Context ctx;
    List<CallNumber> lstNumbers;
    public adt_rv_Emergency(){
        super();
        lstNumbers = new ArrayList<CallNumber>();
        CallNumber c = new CallNumber();
        c.setNumberToCall("191");
        c.setTitle("Call police");
        c.setSubTitle("when you have an accident");
        lstNumbers.add(c);
        c = new CallNumber();
        c.setNumberToCall("166");
        c.setTitle("Call president");
        c.setSubTitle("To tell something wrong about law");
        lstNumbers.add(c);
        c = new CallNumber();
        c.setNumberToCall("185");
        c.setTitle("Call support");
        c.setSubTitle("To Ask something about Cvit detail");
        lstNumbers.add(c);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View v = LayoutInflater.from(ctx).inflate(R.layout.rv_emergency,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CallNumber c =  lstNumbers.get(position);
        holder.tvNumberToCall.setText(c.getNumberToCall());
        holder.tvTile.setText(c.getTitle());
        holder.tvSubTile.setText(c.getSubTitle());
        holder.tvNumberToCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CurrentNumber = "tel:" + c.getNumberToCall().toString();
                int result = ContextCompat.checkSelfPermission(ctx, Manifest.permission.CALL_PHONE);
                if(result == PackageManager.PERMISSION_GRANTED){
                    Intent it = new Intent(Intent.ACTION_CALL);
                    it.setData(Uri.parse(CurrentNumber));
                    ctx.startActivity(it);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstNumbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvNumberToCall;
        protected TextView tvTile;
        protected TextView tvSubTile;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNumberToCall = (TextView) itemView.findViewById(R.id.tvNumberToCall);
            tvTile = (TextView) itemView.findViewById(R.id.tvTitle);
            tvSubTile = (TextView) itemView.findViewById(R.id.tvSubTitle);
        }
    }
}
