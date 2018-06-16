package com.example.administrator.learnandbase.ac

import com.ab.task.AbTaskItem
import com.ab.task.AbTaskPool
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.adapter.RVAdapter0
import com.example.administrator.learnandbase.bean.Bean0
import com.example.administrator.learnandbase.util.AbTaskItemHelper
import com.example.administrator.learnandbase.util.AbTitleBarHelper
import com.example.administrator.learnandbase.util.RecyclerViewHelper
import kotlinx.android.synthetic.main.abac_learn0.*

/**
 * Created by Administrator on 2018/5/31 0031.
 */

class LearnAbAc0 : BaseAbAc() {
    override val layoutResId: Int
        get() = R.layout.abac_learn0

    override fun initOnCreate() {
        val list = ArrayList<Bean0>()
        val rVAdapter0 = RVAdapter0(this, list)
        RecyclerViewHelper.initVerticalLinearRecyclerView(rv, this, rVAdapter0)
        AbTitleBarHelper.initAbTitleBar0(mAbTitleBar, this)

        list.add(Bean0("隐藏标题栏", execute(getAbTaskItem(AbTitleBarHelper.hideAbTitleBar(mAbTitleBar)))))
        list.add(Bean0("显示标题栏", execute(getAbTaskItem(AbTitleBarHelper.showAbTitleBar(mAbTitleBar)))))
        list.add(Bean0("隐藏标题栏右侧", execute(getAbTaskItem(AbTitleBarHelper.hideRightPartOfAbTitleBar(mAbTitleBar)))))
        list.add(Bean0("显示标题栏右侧", execute(getAbTaskItem(AbTitleBarHelper.showRightPartOfAbTitleBar0(mAbTitleBar, this)))))
        list.add(Bean0("变换标题栏", execute(getAbTaskItem(AbTitleBarHelper.changeAbTitleBar(mAbTitleBar, this)))))
        list.add(Bean0("透明背景", execute(getAbTaskItem(AbTitleBarHelper.transparentBackgroundOfAbTitleBar(mAbTitleBar)))))
        list.add(Bean0("隐藏标题栏下拉", execute(getAbTaskItem(AbTitleBarHelper.hideDropDownOfAbTitleBar(mAbTitleBar)))))
        list.add(Bean0("显示标题栏下拉", execute(getAbTaskItem(AbTitleBarHelper.showDropDownOfAbTitleBar0(mAbTitleBar, this)))))
        list.add(Bean0("隐藏副标题栏", execute(getAbTaskItem(AbTitleBarHelper.hideAbBottomBar(mAbBottomBar)))))
        list.add(Bean0("显示副标题栏", execute(getAbTaskItem(AbTitleBarHelper.showAbBottomBar0(mAbBottomBar, this)))))
    }

    val abTaskPool = AbTaskPool.getInstance()!!
    val execute = { abTaskItem: AbTaskItem ->
        {
            abTaskPool.execute(abTaskItem)
        }
    }

    fun getAbTaskItem(update: () -> Unit): AbTaskItem {
        return AbTaskItemHelper.getAbTaskItem(update)
    }
}
