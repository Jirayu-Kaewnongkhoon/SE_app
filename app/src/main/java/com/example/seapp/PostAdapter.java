package com.example.seapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    Context mContext;
    List<Post> mData;


    public PostAdapter(Context mContext, List<Post> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.post_row,parent,false);

        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.profile_name.setText(mData.get(position).getUserid());
        holder.post_detail.setText(mData.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView profile_name,post_detail;
        ImageView profile_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            post_detail = (TextView) itemView.findViewById(R.id.home_post_detail);
            profile_name = (TextView) itemView.findViewById(R.id.home_post_username);
            profile_img = (ImageView) itemView.findViewById(R.id.home_post_image);

        }
    }
}
