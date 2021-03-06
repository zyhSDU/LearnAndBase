package com.example.administrator.learnandbase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import com.ab.global.AbMenuItem
import com.example.administrator.learnandbase.R

/**
 * Created by Administrator on 2018/6/9 0009.
 */

class BaseLVAdapter(private val context: Context, private val list: List<AbMenuItem>, private val itemResource: Int) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //由于我们的ListView中的Item显示的方式都非常的简单，因此ViewHolder类中也就仅仅定义了一个TextView属性...
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        /*这个判断其实是为了复用而定义的...因为ListView都是动态进行加载的..
          如果ListView中的Item超过了屏幕的大小，那么势必就需要进行下拉...
          下拉就代表原来的那些ListView就需要被销毁...
          那么总不能每一次滑动我们都新建立一个ViewHolder对象..我们可以把这些被销毁的ViewHolder进行复用...
          有了复用之后，再次滑动的时候ViewHolder会自动调用那些被销毁掉的进行复用...从而使得资源得到重新加载...
          说白了就是提高了复用性...
         */
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(itemResource, null) //定义一个视图对象View...
            holder = ViewHolder()
            holder.itemText = convertView!!.findViewById(R.id.pop_item) //在当前的View中获取ListView的ID..
            convertView.tag = holder//设置标志..
        } else {
            holder = convertView.tag as ViewHolder//这里可以直接获取标志，对holder进行复用，减少了内存的分配和开销...
        }
        val item = list[position]
        holder.itemText!!.text = item.text //为每一个Item中的TextView设置值...

        return convertView
    }

    internal class ViewHolder {
        var itemText: TextView? = null
    }

}

