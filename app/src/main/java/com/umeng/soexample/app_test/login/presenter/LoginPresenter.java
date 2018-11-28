package com.umeng.soexample.app_test.login.presenter;

import com.umeng.soexample.app_test.login.model.LoginModel;
import com.umeng.soexample.app_test.login.view.LoginView;
import com.umeng.soexample.app_test.net.HttpCallBack;

/**
 * data:2018/11/28
 * author: HJL (磊)
 * function:
 */
public class LoginPresenter {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    public void login(String mobile,String password){
        loginModel.login(mobile, password, new HttpCallBack() {
            @Override
            public void OnSuccess(String result) {
                loginView.OnSuccess(result);
            }

            @Override
            public void OnFaile(String msg) {
                loginView.OnFaile(msg);
            }
        });
    }

}
