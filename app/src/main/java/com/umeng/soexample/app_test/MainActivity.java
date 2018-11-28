package com.umeng.soexample.app_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.umeng.soexample.app_test.login.presenter.LoginPresenter;
import com.umeng.soexample.app_test.login.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {


    private EditText mEdMobile;

    private EditText mEdPass;

    private Button mBtLogin;

    private Button mBtRegistered;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        jump();
        presenter = new LoginPresenter(this);

    }

    private void jump() {
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String moblie = mEdMobile.getText().toString().trim();
                String pass = mEdPass.getText().toString().trim();
                presenter.login(moblie, pass);
            }
        });
    }

    private void initView() {
        mEdMobile = findViewById(R.id.ed_mobile);
        mEdPass = findViewById(R.id.ed_pass);
        mBtLogin = findViewById(R.id.bt_login);
        mBtRegistered = findViewById(R.id.bt_registered);
    }

    @Override
    public void OnSuccess(String Result) {
        Toast.makeText(this, Result, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void OnFaile(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
