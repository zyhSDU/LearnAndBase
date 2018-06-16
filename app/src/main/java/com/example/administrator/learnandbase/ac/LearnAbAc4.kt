package com.example.administrator.learnandbase.ac

import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.util.SlidingMenuHelper

/**
 * Created by Administrator on 2018/6/10 0010.
 */

class LearnAbAc4 : BaseAbAc() {
    override val layoutResId: Int
        get() = R.layout.abac_learn4

    override fun initOnCreate() {
        SlidingMenuHelper.test(this)
    }
}
