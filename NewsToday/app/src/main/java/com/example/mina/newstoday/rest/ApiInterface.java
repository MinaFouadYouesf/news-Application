package com.example.mina.newstoday.rest;

import com.example.mina.newstoday.model.newsContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
//"https://newsapi.org/v2/top-headlines?country=eg&category=sports&apiKey="+API_KEY

public interface ApiInterface {
    @GET("top-headlines")
    Call<newsContent> getNews(@Query("country") String country, @Query("category") String category,
                                        @Query("apiKey") String apiKey);
}
