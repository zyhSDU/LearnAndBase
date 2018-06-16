package com.example.administrator.learnandbase.ac

import android.annotation.SuppressLint
import com.ab.global.AbConstant
import com.example.administrator.learnandbase.R
import android.view.View

class LearnAbAc1 : BaseAbAc() {
    override val layoutResId: Int
        get() = R.layout.abac_learn1

    @SuppressLint("InflateParams")
    override fun initOnClick(view: View, id: Int) {
        val demoText = mInflater.inflate(R.layout.demo_text, null)
        when (id) {
            R.id.but_0 -> showProgressDialog()
            R.id.but_1 -> showToast("Toast")
            R.id.but_2 -> showDialog(AbConstant.DIALOGTOP, demoText)
            R.id.but_3 -> showDialog(AbConstant.DIALOGCENTER, demoText)
            R.id.but_4 -> showDialog(AbConstant.DIALOGBOTTOM, demoText)
            R.id.but_5 -> showDialog("�", "����") { dialog, which ->
                showToast("���ȷ��")
            }
        }
    }
}
