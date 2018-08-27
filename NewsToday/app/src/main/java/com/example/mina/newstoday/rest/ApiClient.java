package com.example.mina.newstoday.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//"https://newsapi.org/v2/top-headlines?country=eg&category=sports&apiKey="+API_KEY
    // [GET] http://grapesnberries.getsandbox.com/products?count=10&from=1
    public static final String BASE_URL = "https://newsapi.org/v2/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
