package com.example.seapp.ui.notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seapp.R;

import java.util.ArrayList;

public class adapterclass extends RecyclerView.Adapter<adapterclass.Holder>      {
    private String mDataSet;
    private String mDataSet1;

    public adapterclass(String dataSet,String dataSet1 ){
        mDataSet = dataSet;
        mDataSet1 =  dataSet1;

    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder,parent,false);
        Holder holder=new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textTitle;
        TextView textDescription;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            textDescription =itemView.findViewById(R.id.text_description);

        }
        public void setItem(int position){
            textTitle.setText(mDataSet);
            textDescription.setText(mDataSet1);
        }
    }

    ArrayList<modelnotification> list;

}
