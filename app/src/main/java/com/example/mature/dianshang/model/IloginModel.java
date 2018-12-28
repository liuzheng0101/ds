package com.example.mature.dianshang.model;

import com.example.mature.dianshang.net.RequestCallback;

import java.util.HashMap;

public interface IloginModel {
    void login(HashMap<String,String> params, RequestCallback requestCallback);
}
