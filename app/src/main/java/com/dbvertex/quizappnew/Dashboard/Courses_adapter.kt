package com.dbvertex.quiz_app.Dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dbvertex.quizappnew.databinding.ItemCouresBinding


class Courses_adapter(val list: List<courses_data>): RecyclerView.Adapter<Courses_adapter.coursesVH>() {


    class coursesVH(val itemCouresBinding: ItemCouresBinding):ViewHolder(itemCouresBinding.root){
        fun onBind(coursesData: courses_data){
            itemCouresBinding.courseName.text=coursesData.course_name.toString()
            itemCouresBinding.courseAdmin.text=coursesData.inst_name.toString()
            itemCouresBinding.coursePrice.text=coursesData.course_price.toString()
            itemCouresBinding.courseRating.text=coursesData.course_rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): coursesVH {
       val item=ItemCouresBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return coursesVH(item)
    }

    override fun onBindViewHolder(holder: coursesVH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
       return  list.size
    }
}