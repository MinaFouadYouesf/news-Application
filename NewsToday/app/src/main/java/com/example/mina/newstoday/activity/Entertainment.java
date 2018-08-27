package com.example.mina.newstoday.activity;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mina.newstoday.Network.networkConnection;
import com.example.mina.newstoday.R;
import com.example.mina.newstoday.adapter.newsAdapter;
import com.example.mina.newstoday.model.newsContent;
import com.example.mina.newstoday.model.newsObject;
import com.example.mina.newstoday.rest.ApiClient;
import com.example.mina.newstoday.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Entertainment extends Fragment {
    newsContent dataObject;
    List<newsObject>dataSet;
    private RecyclerView recyclerView;
    newsAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView=inflater.inflate(R.layout.fragment_entertainment, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.recyclerView);
        dataSet=new ArrayList<>();

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new newsAdapter(getContext(), dataSet);
        recyclerView.setAdapter(adapter);

        if(networkConnection.isNetworkAvailable(getContext()))
        {
            getAllData();

        }else{

            Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }

        return rootView ;
    }

    private void getAllData() {
        String API_KEY = "4d87c60fc7554020852ec6a6252c0499";
        String country="eg";
        String category="entertainment";

        ApiInterface api =
                ApiClient.getClient().create(ApiInterface.class);
        Call<newsContent> call = api.getNews(country,category,API_KEY);

        call.enqueue(new Callback<newsContent>() {
            @Override
            public void onResponse(Call<newsContent> call, Response<newsContent> response) {
                if (response.body() != null) {
                    dataObject=response.body();
                    dataSet.addAll(dataObject.getDataList());
                    adapter.notifyDataSetChanged();
                    //  Toast.makeText(getContext(),dataObject.getDataList().get(0).getTitle(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<newsContent> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("mmmmmmmmmm",t.getMessage());
            }
        });
    }
}
