package com.example.administrator.learnandbase.dao

import android.content.Context

import com.ab.db.orm.dao.AbDBDaoImpl
import com.example.administrator.learnandbase.bean.LocalUser
import com.example.administrator.learnandbase.db.AbDBHelper0

/**
 * Created by Administrator on 2018/6/8 0008.
 */

class LocalUserDao(context: Context) : AbDBDaoImpl<LocalUser>(AbDBHelper0(context), LocalUser::class.java)
