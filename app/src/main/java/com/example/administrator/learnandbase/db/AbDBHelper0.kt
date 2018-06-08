package com.example.administrator.learnandbase.db

import android.content.Context

import com.ab.db.orm.AbDBHelper
import com.example.administrator.learnandbase.bean.LocalUser

/**
 * Created by Administrator on 2018/6/8 0008.
 */


class AbDBHelper0(context: Context) : AbDBHelper(context, DBNAME, null, DBVERSION, clazz) {
    companion object {
        // 数据库名
        private val DBNAME = "learnandbase.db"
        // 当前数据库的版本
        private val DBVERSION = 3
        // 要初始化的表
        private val clazz = arrayOf<Class<*>>(LocalUser::class.java)
    }

}
