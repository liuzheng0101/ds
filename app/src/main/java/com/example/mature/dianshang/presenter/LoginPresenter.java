package com.example.mature.dianshang.presenter;

import com.example.mature.dianshang.entity.UserEntity;
import com.example.mature.dianshang.model.LoginModel;
import com.example.mature.dianshang.net.RequestCallback;
import com.example.mature.dianshang.utils.ValidatorUtil;
import com.example.mature.dianshang.view.IloginView;

import java.util.HashMap;

public class LoginPresenter {
    private LoginModel loginModel;
    private IloginView iloginView;
    public LoginPresenter(IloginView iloginView) {
        loginModel=new LoginModel();
        this.iloginView=iloginView;
    }
    public void login(HashMap<String,String> params){
        String mobile=params.get("mobile");
        String password=params.get("password");
        if(!ValidatorUtil.isMobile(mobile)){
            if (iloginView!=null){
                iloginView.mobileError("请输入合法手机号");
            }
            return;
        }
        if (loginModel!=null){
            loginModel.login(params, new RequestCallback() {
                @Override
                public void failure(String msg) {
                    if (iloginView!=null){
                        iloginView.failure(msg);
                    }
                }
                @Override
                public void successMsg(String msg) {
                    if (iloginView!=null){
                        iloginView.successMsg(msg);
                    }
                }
                @Override
                public void success(UserEntity userEntity) {
                    if (iloginView!=null){
                        iloginView.success(userEntity);
                    }
                }
            });
        }
    }
}
