package com.example.mature.dianshang.net;

import com.example.mature.dianshang.entity.UserEntity;

public interface RequestCallback {
    void failure(String msg);
    void successMsg(String msg);
    void success(UserEntity userEntity);
}
