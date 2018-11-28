package com.umeng.soexample.app_test.loading;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.umeng.soexample.app_test.MainActivity;
import com.umeng.soexample.app_test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动页
 */
public class TransActivity extends AppCompatActivity {

    private ViewPager mVp;

    private Button mBtJump;
    private List imgList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        initView();
        initViewPage();

        mBtJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });

        //判断最后一张图片
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3){
                    mBtJump.setVisibility(View.VISIBLE);
                }else{
                    mBtJump.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void jump() {
        SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
        SharedPreferences.Editor edit = config.edit();
        edit.putBoolean("con",false);
        edit.commit();
        Intent intent = new Intent(TransActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initViewPage() {
        if (isFirst()){
            imgList.add(R.mipmap.b1);
            imgList.add(R.mipmap.b2);
            imgList.add(R.mipmap.b3);
            imgList.add(R.mipmap.b4);
            LoadAdapter adapter = new LoadAdapter(imgList);
            mVp.setAdapter(adapter);
        }else{
         jump();
        }

    }

    private void initView() {
        mVp = findViewById(R.id.vp);
        mBtJump = findViewById(R.id.bt_jump);
    }
    private boolean isFirst(){
        SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
        boolean con = config.getBoolean("con", true);
        return con;
    }
}
