package com.example.administrator.learnandbase.ac

import android.annotation.SuppressLint
import com.ab.global.AbConstant
import com.example.administrator.learnandbase.R
import android.view.View

class LearnAbAc1 : BaseAbAc(), View.OnClickListener {
    override val layoutResId: Int
        get() = R.layout.abac_learn1

    @SuppressLint("InflateParams")
    override fun onClick(v: View, id: Int) {
        val view = mInflater.inflate(R.layout.demo_text, null)
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
    }
}
