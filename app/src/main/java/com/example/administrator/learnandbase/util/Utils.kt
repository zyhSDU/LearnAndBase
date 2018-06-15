package com.example.administrator.learnandbase.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.text.format.DateFormat
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

import com.example.administrator.learnandbase.interfaces.Constants
import com.example.administrator.smartschool.util.Logger

import java.util.Calendar

object Utils {

    fun setButtonOnClickListener(view: View, listener: OnClickListener) {
        if (view is Button || view is ImageButton) {
            view.setOnClickListener(listener)
        } else if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                setButtonOnClickListener(child, listener)
            }
        }
    }

    fun showToast(context: Context, text: String) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    fun getScreenWidth(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return windowManager.defaultDisplay?.width ?: 0
    }


    fun getScreenHeight(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return windowManager.defaultDisplay?.height ?: 0
    }


    fun printCursor(cursor: Cursor?) {
        if (cursor == null) {
            return
        }

        Logger.i(Utils::class.java, "共有" + cursor.count + "条数据")
        // 遍历所有的行
        while (cursor.moveToNext()) {
            // 遍历所有的列
            Logger.i(Utils::class.java, "---------------------")
            for (i in 0 until cursor.columnCount) {
                val columnName = cursor.getColumnName(i)
                val value = cursor.getString(i)
                Logger.i(Utils::class.java, columnName + "=" + value)
            }
        }
    }

    fun formatMillis(duration: Long): CharSequence {
        val calendar = Calendar.getInstance()
        calendar.clear()
        calendar.add(Calendar.MILLISECOND, duration.toInt())
        val inFormat = if (duration / Constants.HOUR_MILLIS > 0) "kk:mm:ss" else "mm:ss"
        return DateFormat.format(inFormat, calendar.time)
    }

    fun dynamicPermission(activity: Activity, vararg permissions: String) {//例子：Manifest.permission.CALL_PHONE
        if (Build.VERSION.SDK_INT >= 23) {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, arrayOf(permission), 1)
                }
            }
        }
    }
}