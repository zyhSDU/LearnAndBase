package com.example.administrator.learnandbase.ac

import com.ab.global.AbMenuItem
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.adapter.LVAdapter0
import com.example.administrator.learnandbase.bean.LocalUser
import com.example.administrator.learnandbase.dao.LocalUserDao
import com.example.administrator.learnandbase.util.AbPullListViewHelper
import com.example.administrator.learnandbase.util.AbPullViewHelper
import com.example.administrator.learnandbase.util.AbTaskItemHelper
import com.example.administrator.smartschool.util.Logger
import kotlinx.android.synthetic.main.abac_learn2.*

/**
 * Created by Administrator on 2018/6/4 0004.
 */

class LearnAbAc2 : BaseAbAc() {
    override val layoutResId: Int
        get() = R.layout.abac_learn2

    //初始化数据库操作实现类
    private var userDao = LocalUserDao(self)

    private fun testDB() {
        //(1)获取数据库
        userDao.startReadableDatabase(false)
        //insert
        val localUser = LocalUser()
        localUser.age = 20
        localUser.createTime = System.currentTimeMillis().toString()
        localUser.name = "nsjfwww"
        localUser.password = "123123"
        localUser.remark = "1212"
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
        val list = arrayOf("111", "112", "121").map {
            AbMenuItem(it)
        }
        mAbPullListView.adapter = LVAdapter0(self, list)
        //打开关闭下拉刷新加载更多功能
        AbPullListViewHelper.setEnable(mAbPullListView)

        AbPullListViewHelper.setAbOnListViewListener(mAbPullListView,
                onRefresh = {
                    AbTaskItemHelper.executeNullAbTaskItemLast(update = {
                        mAbPullListView.stopRefresh()
                    })
                },
                onLoadMore = {
                    AbTaskItemHelper.executeNullAbTaskItemLast(update = {
                        mAbPullListView.stopLoadMore()
                    })
                }
        )

        AbPullViewHelper.setAbOnRefreshListener(mPullView, AbTaskItemHelper.getAbTaskItem(
                get = {
                    testDB()
                },
                update = {
                    mPullView.stopRefresh()
                }
        ))
    }
}
