package com.example.administrator.learnandbase.ac

/**
 * Created by Administrator on 2018/3/23 0023.
 */
import android.os.Bundle
import android.view.View
import com.ab.activity.AbActivity
import com.example.administrator.learnandbase.R
import com.example.administrator.learnandbase.interfaces.UiOperation
import com.example.administrator.learnandbase.util.AbTitleBarHelper
import com.example.administrator.learnandbase.util.Utils

abstract class BaseAbAc : AbActivity(), UiOperation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAbContentView(layoutResId)
        Utils.setAllOnClickListener(this, this)//Activity的根View
        AbTitleBarHelper.initAbTitleBar0(mAbTitleBar,this)
        initOnCreate()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_back -> finish()
            else -> initOnClick(v)
        }
    }
}