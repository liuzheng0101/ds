package com.example.day3.net;

public interface OkhttpCallback {
    void failure(String msg); //服务器请求失败,断网,服务器
    void success(String result);  //数据合法
}
