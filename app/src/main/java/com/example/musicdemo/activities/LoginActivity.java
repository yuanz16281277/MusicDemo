package com.example.musicdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.musicdemo.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * 初始化View
     */
    private void initView(){
        initNavBar(false,"登录",false);
    }
}
