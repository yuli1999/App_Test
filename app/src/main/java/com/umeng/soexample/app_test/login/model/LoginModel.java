package com.umeng.soexample.app_test.login.model;

import com.google.gson.Gson;
import com.umeng.soexample.app_test.login.bean.Bean;
import com.umeng.soexample.app_test.net.HttpCallBack;
import com.umeng.soexample.app_test.net.HttpUtil;

/**
 * data:2018/11/28
 * author: HJL (磊)
 * function:
 */
public class LoginModel {

    public void login(String uname, String password, final HttpCallBack callBack){
        String url = "http://www.zhaoapi.cn/user/login?mobile="+ uname + "&password=" + password;
        new HttpUtil().get(url).Result(new HttpUtil.HttpListener() {
            @Override
            public void OnSuccess(String data) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(data, Bean.class);
                if (bean.getCode().equals("0")){
                    callBack.OnSuccess(bean.getMsg());
                }else{
                    callBack.OnFaile(bean.getMsg());
                }
            }

            @Override
            public void Onfaile() {

            }
        });
    }
}
