package com.example.administrator.learnandbase.ac

import android.view.View
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.adapter.RVAdapter3
import com.example.administrator.learnandbase.util.RecyclerViewHelper
import kotlinx.android.synthetic.main.abac_learn_main.*

/**
 * Created by Administrator on 2018/6/9 0009.
 */

class LearnAbAcMain : BaseAbAc() {
    override val layoutResId: Int
        get() = R.layout.abac_learn_main

    override fun initOnCreate() {
        RecyclerViewHelper.initVerticalLinearRecyclerView(rv, this, RVAdapter3(this, arrayOfClasss))
    }

    val arrayOfClasss = arrayOf(
            LearnAbAc0::class.java,
            LearnAbAc1::class.java,
            LearnAbAc2::class.java,
            LearnAbAc3::class.java,
            LearnAbAc4::class.java
    ).map { it }
}
