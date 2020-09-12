package com.abdalqader27.electriccalculatorruler.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdalqader27.electriccalculatorruler.Models.RulerItem
import com.abdalqader27.electriccalculatorruler.R
import kotlinx.android.synthetic.main.ruler_item.view.*

class RulerAdapterItem(private val rulerList: List<RulerItem>) :
    RecyclerView.Adapter<RulerAdapterItem.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.ruler_item,
            parent, false)
        return ExampleViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = rulerList[position]
        holder.title.text = currentItem.title
        holder.subtitle.text = currentItem.subtitle
        holder.value.text = currentItem.value
    }
    override fun getItemCount() = rulerList.size
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.title
        val subtitle: TextView = itemView.subtitle
        val value: TextView = itemView.value
    }
}