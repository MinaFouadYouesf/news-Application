package com.example.mina.newstoday.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mina.newstoday.Network.networkConnection;
import  com.example.mina.newstoday.R;
import java.util.ArrayList;
import java.util.List;

import com.example.mina.newstoday.activity.displayWebView;
import com.example.mina.newstoday.model.newsObject;
import com.squareup.picasso.Picasso;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.MyViewHolder> {

    private Context mContext;
    private List<newsObject> data;

    public newsAdapter(Context mContext, List<newsObject> data) {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_design, parent, false);
        final MyViewHolder mViewHolder = new MyViewHolder(itemView);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        String Null="null";
        holder.author.setText(data.get(position).getAuthor());
       holder.sdetails.setText(data.get(position).getDescription());
       holder.title.setText(data.get(position).getTitle());
       holder.time.setText(data.get(position).getPublishedAt());
       // Log.d("mmmmmmmmmmm",data.get(position).getUrlToImage());
     /*  if(Null.trim().equals(data.get(position).getUrlToImage().trim()))
        {
            holder.galleryImage.setVisibility(View.GONE);
        }else{*/
     try {
         Picasso.with(mContext)
                 .load(data.get(position).getUrlToImage())
                 .resize(300, 200)
                 .into(holder.galleryImage);
     }catch(NullPointerException e){
         holder.galleryImage.setVisibility(View.GONE);
     }catch (Exception e){
         holder.galleryImage.setVisibility(View.GONE);
         }
       // }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(networkConnection.isNetworkAvailable(mContext))
                {
                    Intent intent=new Intent(mContext.getApplicationContext(),displayWebView.class);
                    intent.putExtra("url",(data.get(position).getUrl()).toString());
                    mContext.startActivity(intent);
                }else{

                    Toast.makeText(mContext, "No Internet Connection", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public int getItemCount(){
        return data.size();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryImage;
        TextView author, title, sdetails, time;
        LinearLayout  linearLayout;
        public MyViewHolder(View view) {
            super(view);
            galleryImage = (ImageView) view.findViewById(R.id.galleryImage);
            author = (TextView) view.findViewById(R.id.author);
            title = (TextView) view.findViewById(R.id.title);
            sdetails = (TextView) view.findViewById(R.id.sdetails);
            time = (TextView) view.findViewById(R.id.time);
            linearLayout=(LinearLayout)view.findViewById(R.id.linear);

        }
    }
}
