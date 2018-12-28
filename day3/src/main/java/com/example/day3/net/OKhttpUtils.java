package com.example.day3.net;

import android.os.Handler;

import okhttp3.OkHttpClient;

public class OKhttpUtils {
    private Handler handler=new Handler();
    private OkHttpClient okHttpClient;
    private static  OKhttpUtils instance; //私有属性

    private OKhttpUtils(){
        
    }

    public static OKhttpUtils getInstance() {
        return instance;
    }
}
