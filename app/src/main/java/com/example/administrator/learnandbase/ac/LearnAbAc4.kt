package com.example.administrator.learnandbase.ac

import android.view.View
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.util.SlidingMenuHelper

/**
 * Created by Administrator on 2018/6/10 0010.
 */

class LearnAbAc4 : BaseAbAc() {
    override fun getLayoutResId(): Int {
        return R.layout.abac_learn4
    }

    override fun initData() {

    }

    override fun initView() {
        SlidingMenuHelper.test(self)
    }

    override fun initListener() {

    }

    override fun onClick(v: View, id: Int) {

    }
}
