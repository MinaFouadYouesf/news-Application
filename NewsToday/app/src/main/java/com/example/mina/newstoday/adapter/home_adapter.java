package com.example.mina.newstoday.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mina.newstoday.R;
import com.example.mina.newstoday.activity.MainActivity;
import com.example.mina.newstoday.model.homeObject;

import java.util.List;


public class home_adapter extends RecyclerView.Adapter<home_adapter.MyViewHolder> {

    private Context mContext;
    private List<homeObject> newsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView  imageView;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            imageView = (ImageView) view.findViewById(R.id.thumbnail);
            cardView=(CardView)view.findViewById(R.id.card_view);
        }
    }


    public home_adapter(Context mContext, List<homeObject> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        homeObject Object = newsList.get(position);
        holder.title.setText(Object.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(mContext, String.valueOf(position), Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(mContext, MainActivity.class);
               mContext.startActivity(intent);
            }
        });

        // loading album cover using Glide library
        Glide.with(mContext).load(Object.getImg()).into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }
}