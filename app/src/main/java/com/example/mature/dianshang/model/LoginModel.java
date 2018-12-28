package com.example.mature.dianshang.model;

import android.os.Handler;
import android.text.TextUtils;

import com.example.mature.dianshang.api.UserApi;
import com.example.mature.dianshang.entity.UserEntity;
import com.example.mature.dianshang.net.RequestCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements IloginModel {
    private Handler handler=new Handler();
    @Override
    public void login(HashMap<String, String> params,final RequestCallback callback) {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();

        FormBody.Builder formBody=new FormBody.Builder();
        for (Map.Entry<String,String> p: params.entrySet()){
            formBody.add(p.getKey(),p.getValue());
        }
        final Request request=new Request.Builder().url(UserApi.USER_LOGIN).post(formBody.build()).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("eeeee:"+e);
                if (callback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络不稳定,请稍后重试");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                int code=response.code();
                if (!TextUtils.isEmpty(result)){
                    paseResult(result,callback,code);
                }
            }
        });
    }
    private void paseResult(String result, final RequestCallback callback, int code) {
        final UserEntity userEntity=new Gson().fromJson(result,UserEntity.class);
        if (callback!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.success(userEntity);
                }
            });
        }
    }
}
