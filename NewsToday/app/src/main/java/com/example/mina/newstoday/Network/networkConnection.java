package com.example.mina.newstoday.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class networkConnection {

   public networkConnection(){}
    public static boolean isNetworkAvailable(Context context)
    {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    }
