package com.dbvertex.quiz_app.Intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dbvertex.quiz_app.Intro.goal_adapter.*
import com.dbvertex.quizappnew.databinding.ItemExamBinding


class goal_adapter(val list: List<goal_item_data>): RecyclerView.Adapter<goal_vh>() {

class goal_vh(val binding: ItemExamBinding): ViewHolder(binding.root) {
    fun onBind(goalItemData: goal_item_data){
        binding.examName.text=goalItemData.nam.toString()
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): goal_vh {
        val item= ItemExamBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  goal_vh(item)
    }

    override fun onBindViewHolder(holder: goal_vh, position: Int) {
       holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}