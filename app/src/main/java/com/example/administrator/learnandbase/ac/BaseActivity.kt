package com.example.administrator.learnandbase.ac

/**
 * Created by Administrator on 2018/3/23 0023.
 */
import android.os.Bundle
import android.view.View
import com.ab.activity.AbActivity
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.interfaces.UiOperation
import com.example.administrator.learnandbase.util.Utils

abstract class BaseActivity : AbActivity(), UiOperation {
    protected val self: BaseActivity
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE)//我我我我我
        super.onCreate(savedInstanceState)
        setAbContentView(layoutResId)
        initPermission()
        initData()
        initView()
        Utils.setButtonOnClickListener(findViewById<View>(android.R.id.content), this)//Activity的根View
        initListener()
    }

    open fun initPermission() {}
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_back -> finish()
            else -> onClick(v, v.id)
        }
    }
}