package com.example.mina.newstoday.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.mina.newstoday.R;
import com.example.mina.newstoday.adapter.*;
import com.example.mina.newstoday.model.homeObject;

import java.util.ArrayList;
import java.util.List;

public class Home_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private home_adapter adapter;
    private List<homeObject> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newsList = new ArrayList<>();
        adapter = new home_adapter (this, newsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();


    }

    private void prepareAlbums() {


        newsList.add(new homeObject(R.drawable.egypt_flag, "أخبار مصر"));
        newsList.add(new homeObject(R.drawable.world_flag, "أخبار العالم"));
        newsList.add(new homeObject(R.drawable.bitcoin, "أخبار البيتكوين"));



        adapter.notifyDataSetChanged();
    }
}
