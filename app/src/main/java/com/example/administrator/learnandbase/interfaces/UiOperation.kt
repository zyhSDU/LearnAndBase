package com.example.administrator.learnandbase.interfaces

import android.view.View
import android.view.View.OnClickListener

interface UiOperation : OnClickListener {

    val layoutResId: Int

    fun initOnCreate() {}

    fun initOnClick(view: View, id: Int = view.id) {}
}