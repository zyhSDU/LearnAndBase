package com.example.administrator.learnandbase.ac

import android.view.View
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.bean.LocalUser
import com.example.administrator.learnandbase.dao.LocalUserDao
import com.example.administrator.smartschool.util.Logger

/**
 * Created by Administrator on 2018/6/4 0004.
 */

class LearnAbAc2 : BaseAbAc() {
    override fun getLayoutResId(): Int {
        return R.layout.abac_learn2
    }

    private lateinit var userDao: LocalUserDao

    override fun initData() {
        //初始化数据库操作实现类
        userDao = LocalUserDao(self)

        //(1)获取数据库
        userDao.startReadableDatabase(false)
        //insert
        val localUser = LocalUser()
        localUser.age=20
        localUser.createTime= System.currentTimeMillis().toString()
        localUser.name="nsjfwww"
        localUser.password="123123"
        localUser.remark="1212"
        userDao.insert(localUser)
        //(2)执行查询
        val userList = userDao.queryList(null, null, null, null, null, null, null)
        val totalCount = userDao.queryCount(null, null)
        //(3)关闭数据库
        userDao.closeDatabase(false)

        userList.forEach {
            Logger.e(self, it.toString())
        }
        Logger.e(self, totalCount.toString())
    }

    override fun initView() {

    }

    override fun initListener() {

    }


    override fun onClick(v: View, id: Int) {

    }
}
