package com.example.administrator.learnandbase.interfaces;

import android.view.View;
import android.view.View.OnClickListener;

public interface UiOperation extends OnClickListener {

    int getLayoutResId();

    void initData();

    void initView();

    void initListener();

    void onClick(View v, int id);
}