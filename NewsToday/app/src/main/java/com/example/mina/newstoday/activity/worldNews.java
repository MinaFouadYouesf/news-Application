package com.example.mina.newstoday.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class worldNews extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_news);

    }
}
