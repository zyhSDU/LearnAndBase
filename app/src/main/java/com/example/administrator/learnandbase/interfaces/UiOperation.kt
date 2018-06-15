package com.example.administrator.learnandbase.interfaces

import android.view.View
import android.view.View.OnClickListener

interface UiOperation : OnClickListener {

    val layoutResId: Int

    fun initPermission(){}

    fun initData(){}

    fun initView(){}

    fun initListener(){}

    fun onClick(v: View, id: Int){}
}