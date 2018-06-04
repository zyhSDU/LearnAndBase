package com.example.administrator.learnandbase.ac

import android.annotation.SuppressLint
import android.view.View
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.adapter.RVAdapter0
import com.example.administrator.learnandbase.util.AbTitleBarHelper
import com.example.administrator.learnandbase.util.RecyclerViewHelper
import kotlinx.android.synthetic.main.abac_learn0.*
import com.ab.task.AbTaskPool
import com.example.administrator.learnandbase.util.AbTaskItemHelper

/**
 * Created by Administrator on 2018/5/31 0031.
 */

class LearnAbAc0 : BaseAbAc() {
    var abTaskPool = AbTaskPool.getInstance()!!
    val abTaskItemHideAbTitleBar = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.hideAbTitleBar(mAbTitleBar)
    }
    val abTaskItemShowAbTitleBar = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.showAbTitleBar(mAbTitleBar)
    }
    val abTaskItemHideRightPartOfAbTitleBar = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.hideRightPartOfAbTitleBar(mAbTitleBar)
    }
    val abTaskItemShowRightPartOfAbTitleBar0 = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.showRightPartOfAbTitleBar0(mAbTitleBar, self)
    }
    val abTaskItemChangeAbTitleBar = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.changeAbTitleBar(mAbTitleBar, self)
    }
    val abTaskItemTransparentBackgroundOfAbTitleBar = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.transparentBackgroundOfAbTitleBar(mAbTitleBar)
    }
    val abTaskItemHideDropDownOfAbTitleBar = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.hideDropDownOfAbTitleBar(mAbTitleBar)
    }
    val abTaskItemShowDropDownOfAbTitleBar0 = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.showDropDownOfAbTitleBar0(mAbTitleBar, self)
    }
    val abTaskItemHideAbBottomBar = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.hideAbBottomBar(mAbBottomBar)
    }
    val abTaskItemShowAbBottomBar0 = AbTaskItemHelper.getAbTaskItemWithUpdateMethod {
        AbTitleBarHelper.showAbBottomBar0(mAbBottomBar, self)
    }

    private var arrOfStr = arrayListOf(
            "隐藏标题栏", "显示标题栏", "隐藏标题栏右侧", "显示标题栏右侧", "变换标题栏",
            "透明背景", "隐藏标题栏下拉", "显示标题栏下拉", "隐藏副标题栏", "显示副标题栏"
    )
    private var rVAdapter0 = RVAdapter0(self, arrOfStr)
    override fun getLayoutResId(): Int {
        return R.layout.abac_learn0
    }

    override fun initData() {
    }

    @SuppressLint("ResourceType")
    override fun initView() {
        RecyclerViewHelper.initVerticalLinearRecyclerView(rv, self, rVAdapter0)
        AbTitleBarHelper.initAbTitleBar0(mAbTitleBar, self)
    }

    override fun initListener() {}

    override fun onClick(v: View?, id: Int) {
    }
}
