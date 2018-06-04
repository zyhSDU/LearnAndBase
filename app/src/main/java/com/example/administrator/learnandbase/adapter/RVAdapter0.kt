package com.example.administrator.learnandbase.adapter

import android.content.Context
import android.widget.Button
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.ac.LearnAbActivity0

import kotlin.collections.ArrayList

/**
 * Created by Administrator on 2018/5/31 0031.
 */

class RVAdapter0(context: Context, arrayList: List<Any>) : BaseRVAdapter(context, arrayList) {
    override val layoutId: Int
        get() = R.layout.item0

    override val arrOfResId: ArrayList<Int>
        get() = arrayListOf(R.id.btn_item_view)

    private val learnAbActivity0 = context as LearnAbActivity0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val string = arrOfData[position] as String
        val button = holder.arrOfView[0] as Button
        button.text = string
        button.setOnClickListener {
            when (position) {
                0 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemHideAbTitleBar)
                1 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemShowAbTitleBar)
                2 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemHideRightPartOfAbTitleBar)
                3 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemShowRightPartOfAbTitleBar0)
                4 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemChangeAbTitleBar)
                5 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemTransparentBackgroundOfAbTitleBar)
                6 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemHideDropDownOfAbTitleBar)
                7 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemShowDropDownOfAbTitleBar0)
                8 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemHideAbBottomBar)
                9 -> learnAbActivity0.abTaskPool.execute(learnAbActivity0.abTaskItemShowAbBottomBar0)
            }
        }
    }
}
