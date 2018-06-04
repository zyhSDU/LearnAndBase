package com.example.administrator.learnandbase.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.learnandbase.interfaces.Constants;
import com.example.administrator.smartschool.util.Logger;

import java.util.Calendar;

public class Utils {

	public static void setButtonOnClickListener(View view, OnClickListener listener) {
		if (view instanceof Button || view instanceof ImageButton) {
			view.setOnClickListener(listener);
		} else if (view instanceof ViewGroup) {
			ViewGroup viewGroup = (ViewGroup) view;
			for (int i = 0; i < viewGroup.getChildCount(); i++) {
				View child = viewGroup.getChildAt(i);
				setButtonOnClickListener(child, listener);
			}
		}
	}

	public static void showToast(Context context, String text) {
		Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	public static int getScreenWidth(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		return windowManager != null ? windowManager.getDefaultDisplay().getWidth() : 0;
	}
	

	public static int getScreenHeight(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		return windowManager != null ? windowManager.getDefaultDisplay().getHeight() : 0;
	}

	
	public static void printCursor(Cursor cursor) {
		if (cursor == null) {
			return ;
		}
		
		Logger.INSTANCE.i(Utils.class, "共有" + cursor.getCount() + "条数据");
		// 遍历所有的行
		while (cursor.moveToNext()) {
			
			// 遍历所有的列
			Logger.INSTANCE.i(Utils.class, "---------------------");
			for (int i = 0; i < cursor.getColumnCount(); i++) {
				String columnName = cursor.getColumnName(i);
				String value = cursor.getString(i);
				Logger.INSTANCE.i(Utils.class, columnName + "=" + value);
			}
		}
	}

	public static CharSequence formatMillis(long duration) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.add(Calendar.MILLISECOND, (int) duration);
		CharSequence inFormat = duration / Constants.HOUR_MILLIS > 0 ? "kk:mm:ss" : "mm:ss";
		return DateFormat.format(inFormat, calendar.getTime());
	}

	public static void dynamicPermission(Activity activity, String... permissions) {//例子：Manifest.permission.CALL_PHONE
		if (Build.VERSION.SDK_INT >= 23) {
			for (String permission : permissions) {
				if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
					ActivityCompat.requestPermissions(activity, new String[]{permission}, 1);
				}
			}
		}
	}
}