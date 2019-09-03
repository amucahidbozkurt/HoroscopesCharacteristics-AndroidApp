package com.ahmetmb.horoscopeguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.one_line.view.*

class HoroscopesBaseAdapter(context: Context, allHoroscopInfo: ArrayList<Horoscopes>): BaseAdapter() {

    var allHoroscopes = ArrayList<Horoscopes>()
    var context: Context

    init {

        this.allHoroscopes = allHoroscopInfo
        this.context = context

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var one_line_view = convertView
        var viewHolder: ViewHolder

        if (one_line_view == null) {

            var inflater = LayoutInflater.from(context)
            one_line_view = inflater.inflate(R.layout.one_line, parent, false )

            viewHolder = ViewHolder(one_line_view)
            one_line_view.tag = viewHolder
        } else {

            viewHolder = one_line_view.getTag() as ViewHolder
        }

        viewHolder.textHoroscopeName.setText(allHoroscopes.get(position).horoNames)
        viewHolder.textHoroscopeDates.setText(allHoroscopes.get(position).horoDates)
        viewHolder.imgHoroscopeIcon.setImageResource(allHoroscopes.get(position).horoImages)

        return one_line_view
    }

    override fun getItem(position: Int): Any {
        return allHoroscopes.get(position )
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return allHoroscopes.size
    }
}

class ViewHolder (one_line_view: View) {

    var textHoroscopeName: TextView
    var textHoroscopeDates: TextView
    var imgHoroscopeIcon: ImageView

    init {
        this.textHoroscopeName = one_line_view.textHoroscopeName
        this.textHoroscopeDates = one_line_view.textHoroscopeDates
        this.imgHoroscopeIcon = one_line_view.imgHoroscopeIcon
    }

}