package com.example.mature.dianshang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mature.dianshang.R;
import com.example.mature.dianshang.entity.UserEntity;
import com.example.mature.dianshang.presenter.LoginPresenter;
import com.example.mature.dianshang.view.IloginView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity  implements IloginView {

    private LoginPresenter presenter;
    private EditText user,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.user);
        password=findViewById(R.id.passowrd);
        initData();
    }

    private void initData() {
        presenter=new LoginPresenter(this);
    }

    public void login(View view) {
        String pass=password.getText().toString();
        String name=user.getText().toString();
        HashMap<String,String> params=new HashMap<>();
        params.put("mobile",name);
        params.put("password",pass);
        if (presenter!=null){
            presenter.login(params);
        }
    }

    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void pwdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void success(UserEntity userEntity) {
        Toast.makeText(this,userEntity.msg+"",Toast.LENGTH_LONG).show();
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
