package com.example.maryannemillicent.myproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by maryanne millicent on 2/10/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private final LayoutInflater inflater;
    List<HospitalsInformation> hospitaldata= Collections.emptyList();//to avoid nullpoint expection
    Context context;

    public Adapter(Context context,List<HospitalsInformation> hospitaldata){

        inflater= LayoutInflater.from(context);

        this.context=context;
        this.hospitaldata=hospitaldata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =inflater.inflate(R.layout.item,null);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//intiliaze the objects

       HospitalsInformation information = new HospitalsInformation( );//Calling the objects in the list
     information =hospitaldata.get(position);

        holder.name.setText(information.name);
        holder.location.setText(information.location);
        holder.image.setImageResource(information.image);
    }

    @Override
    public int getItemCount() {
        return hospitaldata.size();//sets the items counts and returns an error
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,location;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            name =(TextView) itemView.findViewById(R.id.textView2);
                    location=(TextView) itemView.findViewById(R.id.textView3);
                  image = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }

}
