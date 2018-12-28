package com.example.mature.dianshang.view;

import com.example.mature.dianshang.entity.UserEntity;

public interface IloginView {
    void mobileError(String msg);
    void pwdError(String msg);
    void failure(String msg);
    void success(UserEntity userEntity);
    void successMsg(String msg);
}
