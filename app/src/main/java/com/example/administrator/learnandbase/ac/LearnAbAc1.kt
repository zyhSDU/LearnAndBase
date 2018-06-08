package com.example.administrator.learnandbase.ac

import android.annotation.SuppressLint
import com.ab.global.AbConstant
import com.example.administrator.learnandbase.R
import android.view.View

class LearnAbAc1 : BaseAbAc(), View.OnClickListener {
    override fun getLayoutResId(): Int {
        return R.layout.abac_learn1
    }

    override fun initData() {
    }

    override fun initView() {
    }
    override fun initListener() {
    }

    @SuppressLint("InflateParams")
    private var view = mInflater.inflate(R.layout.demo_text, null)

    override fun onClick(v: View?, id: Int) {
        when (id) {
            R.id.but_0 -> showProgressDialog()
            R.id.but_1 -> showToast("Toast")
            R.id.but_2 -> showDialog(AbConstant.DIALOGTOP, view)
            R.id.but_3 -> showDialog(AbConstant.DIALOGCENTER, view)
            R.id.but_4 -> showDialog(AbConstant.DIALOGBOTTOM, view)
            R.id.but_5 -> showDialog("�", "����") { dialog, which ->
                showToast("���ȷ��")
            }
        }
    }////////////////////////////543435434333
}