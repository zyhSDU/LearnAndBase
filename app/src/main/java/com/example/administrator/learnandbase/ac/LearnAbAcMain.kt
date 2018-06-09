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
    override fun getLayoutResId(): Int {
        return R.layout.abac_learn_main
    }

    override fun initData() {

    }

    val arrayOfClasss = arrayOf(
            LearnAbAc0::class.java,
            LearnAbAc1::class.java,
            LearnAbAc2::class.java,
            LearnAbAc3::class.java
    ).map { it }

    override fun initView() {
        RecyclerViewHelper.initVerticalLinearRecyclerView(rv, self, RVAdapter3(self, arrayOfClasss))

    }

    override fun initListener() {

    }

    override fun onClick(v: View, id: Int) {

    }
}
