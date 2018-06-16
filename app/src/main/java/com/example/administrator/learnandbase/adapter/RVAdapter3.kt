package com.example.administrator.learnandbase.adapter

import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.ac.LearnAbAc0
import com.example.administrator.learnandbase.ac.LearnAbAc1
import com.example.administrator.learnandbase.ac.LearnAbAc2
import java.util.ArrayList

/**
 * Created by Administrator on 2018/6/9 0009.
 */

class RVAdapter3(context: Context, list: List<Any>) : BaseRVAdapter(context, list) {
    override val layoutId: Int
        get() = R.layout.item_rv_3

    override val arrOfResId: ArrayList<Int>
        get() = arrayListOf(R.id.tv_item_rv_3)

    override fun onBindViewHolder(holder: BaseRVAdapter.MyViewHolder, position: Int) {
        val clazz = arrOfData[position] as Class<*>
        val view = holder.arrOfView[0] as TextView
        view.text = clazz.simpleName
        view.setOnClickListener {
            context.startActivity(Intent(context, clazz))
        }
    }
}
