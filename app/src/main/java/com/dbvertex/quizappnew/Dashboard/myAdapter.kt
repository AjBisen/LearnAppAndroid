package com.dbvertex.quiz_app.Dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dbvertex.quizappnew.databinding.ItemDashboardBinding


class myAdapter(val list: List<String>) : RecyclerView.Adapter<myAdapter.viewHolder>() {

    class viewHolder(val item: ItemDashboardBinding) : RecyclerView.ViewHolder(item.root) {
        fun onBind(title: String) {
            item.itemText.text = title.toString()
            item.root.setOnClickListener {
                Log.d("clickcheck", "clicked")
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val item = ItemDashboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(item)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}