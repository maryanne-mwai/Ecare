package com.example.maryannemillicent.myproject;

import android.content.Context;
import android .support.v7.recyclerview.*;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import static com.example.maryannemillicent.myproject.R.drawable.i;

/**
 * Created by Maryanne Mwai on 2/23/2017.
 */

public class DocAdapter extends RecyclerView.Adapter<DocAdapter.MyViewHolder>{

    private final LayoutInflater inflater;
    List<doctorsinformation> doctorsdata= Collections.emptyList();//to avoid nullpoint expection
    Context context;

    //create constructor,context,inflator
    public DocAdapter(Context context,List<doctorsinformation> doctorsdata){
        inflater= LayoutInflater.from(context);
        this.context=context;
        this.doctorsdata=doctorsdata;
    }

    @Override
    public DocAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.doctor,parent,false));
    }

    @Override
    public void onBindViewHolder(DocAdapter.MyViewHolder holder, int position) {
        doctorsinformation doctorsinformation = doctorsdata.get(position);
        holder.name.setText(doctorsinformation.name);
        holder.location.setText(doctorsinformation.location);
        holder.image.setImageDrawable(context.getResources().getDrawable(doctorsinformation.image));
    }

    @Override
    public int getItemCount() {
        return doctorsdata.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, location;

      ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvName);
            location = (TextView) itemView.findViewById(R.id.tvLocation);
            image =(ImageView) image.findViewById(R.id.IVdoc);
        }
    }
}
