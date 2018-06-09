package com.example.administrator.learnandbase.ac

import android.view.View
import android.widget.Toast
import com.ab.global.AbMenuItem
import com.ab.view.listener.AbOnListViewListener
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.adapter.LVAdapter0
import com.example.administrator.learnandbase.bean.LocalUser
import com.example.administrator.learnandbase.dao.LocalUserDao
import com.example.administrator.learnandbase.util.AbPullViewHelper
import com.example.administrator.learnandbase.util.AbTaskItemHelper
import com.example.administrator.smartschool.util.Logger
import kotlinx.android.synthetic.main.abac_learn2.*

/**
 * Created by Administrator on 2018/6/4 0004.
 */

class LearnAbAc2 : BaseAbAc() {
    override fun getLayoutResId(): Int {
        return R.layout.abac_learn2
    }

    //初始化数据库操作实现类
    private var userDao = LocalUserDao(self)

    override fun initData() {

    }

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
        mListView.adapter = LVAdapter0(self, list)
        //打开关闭下拉刷新加载更多功能
        mListView.setPullRefreshEnable(true)
        mListView.setPullLoadEnable(true)

        //设置进度条的样式
        mListView.headerView.setHeaderProgressBarDrawable(this.resources.getDrawable(R.drawable.progress_circular))
        mListView.footerView.setFooterProgressBarDrawable(this.resources.getDrawable(R.drawable.progress_circular))

        mListView.setAbOnListViewListener(object : AbOnListViewListener {
            override fun onRefresh() {
                AbTaskItemHelper.executeNullAbTaskItemLast(1000, {
                    mListView.stopRefresh()
                })
            }

            override fun onLoadMore() {
                AbTaskItemHelper.executeNullAbTaskItemLast(1000, {
                    mListView.stopLoadMore()
                })
            }

        })
    }

    override fun initListener() {
        AbPullViewHelper.setHeaderProgressBarDrawable(mPullView, self)
        AbPullViewHelper.setAbOnRefreshListener(mPullView, AbTaskItemHelper.getAbTaskItem(
                get = {
                    testDB()
                },
                update = {
                    mPullView.stopRefresh()
                }
        ))
    }

    override fun onClick(v: View, id: Int) {

    }
}
