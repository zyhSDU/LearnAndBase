package com.example.administrator.learnandbase.util

import com.ab.task.AbTaskItem
import com.ab.task.AbTaskListener

/**
 * Created by Administrator on 2018/6/2 0002.
 */

object AbTaskItemHelper {
    fun getAbTaskItem(abTaskListener: AbTaskListener):AbTaskItem{
        val abTaskItem = AbTaskItem()
        abTaskItem.listener=abTaskListener
        return abTaskItem
    }

    fun getAbTaskItemWithUpdateMethod(update: () -> Unit):AbTaskItem{
        val abTaskItem = AbTaskItem()
        abTaskItem.listener=object :AbTaskListener(){
            override fun update() {
                update()
            }
        }
        return abTaskItem
    }
}
