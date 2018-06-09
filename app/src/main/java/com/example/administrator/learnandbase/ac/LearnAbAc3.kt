package com.example.administrator.learnandbase.ac

import android.view.Gravity
import android.view.View
import android.widget.GridView
import com.example.administrator.learnandbase.R
import kotlinx.android.synthetic.main.abac_learn3.*
import com.ab.view.listener.AbOnListViewListener
import com.example.administrator.learnandbase.util.AbPullGridViewHelper
import com.example.administrator.learnandbase.util.AbTaskItemHelper


/**
 * Created by Administrator on 2018/6/4 0004.
 */

class LearnAbAc3 : BaseAbAc() {
    override fun getLayoutResId(): Int {
        return R.layout.abac_learn3
    }

    override fun initData() {

    }

    override fun initView() {
        AbPullGridViewHelper.setEnable(mAbPullGridView)
        AbPullGridViewHelper.setProgressBarDrawable(mAbPullGridView, self)

        val mGridView = mAbPullGridView.gridView
        mGridView.columnWidth = 150         //设置列的宽度..
        mGridView.gravity = Gravity.CENTER  //对齐方式为中央对其..
        mGridView.horizontalSpacing = 5     //设置水平间距..
        mGridView.numColumns = GridView.AUTO_FIT    //列的数量为自适应屏幕为限制..
        mGridView.setPadding(5, 5, 5, 5)    //设置间距..
        mGridView.stretchMode = GridView.STRETCH_COLUMN_WIDTH
        mGridView.verticalSpacing = 5               //GridView之间的垂直间距..

        AbPullGridViewHelper.setAbOnListViewListener(
                mAbPullGridView,
                onRefresh = {
                    AbTaskItemHelper.executeNullAbTaskItemLast(update = {
                        mAbPullGridView.stopRefresh()
                    })
                },
                onLoadMore = {
                    AbTaskItemHelper.executeNullAbTaskItemLast(update = {
                        mAbPullGridView.stopLoadMore()
                    })
                }
        )
    }

    override fun initListener() {
    }

    override fun onClick(v: View, id: Int) {

    }
}