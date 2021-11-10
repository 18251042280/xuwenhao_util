package com.bawei.mvvm;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Android Studio.
 * User: 小徐
 * Date: 2021/11/9
 * Time: 18:41
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEnv();
        initEvent();
        initData();
    }

    protected abstract void initEnv();

    protected abstract void initData();

    protected abstract void initEvent();
}