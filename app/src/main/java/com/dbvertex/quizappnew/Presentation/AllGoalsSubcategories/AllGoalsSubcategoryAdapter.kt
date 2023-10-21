package com.dbvertex.quizappnew.Presentation.AllGoalsSubcategories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dbvertex.quizappnew.databinding.ItemAllGoalsBinding
import com.dbvertex.quizappnew.databinding.ItemAllgoalsSubcategoryBinding
import com.dbvertex.quizappnew.databinding.ItemAllgoalsSubcategoryBindingImpl

class AllGoalsSubcategoryAdapter(val list: List<AllGoalsCategoryDTO>, val allGoalsInteface: AllGoalsSubcategoryInteface) :
    RecyclerView.Adapter<AllGoalsSubcategoryAdapter.AllGoalsViewHolder>() {


    class AllGoalsViewHolder(val itemAllgoalsSubcategoryBinding: ItemAllgoalsSubcategoryBinding) :
        RecyclerView.ViewHolder(itemAllgoalsSubcategoryBinding.root) {
        fun onBind(allGoalsDTO: AllGoalsCategoryDTO, allGoalsInteface: AllGoalsSubcategoryInteface) {
            Glide.with(itemAllgoalsSubcategoryBinding.img1.context).load(allGoalsDTO.image)
                .into(itemAllgoalsSubcategoryBinding.img1)
            itemAllgoalsSubcategoryBinding.headline.text = allGoalsDTO.title.toString()
            itemAllgoalsSubcategoryBinding.root.setOnClickListener {
                allGoalsInteface.onClickSingleAllGoal(allGoalsDTO)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllGoalsViewHolder {
        val itemAllgoalsSubcategoryBinding =ItemAllgoalsSubcategoryBinding.inflate(LayoutInflater.from(parent.context))
        return AllGoalsViewHolder(itemAllgoalsSubcategoryBinding)
    }

    override fun onBindViewHolder(holder: AllGoalsViewHolder, position: Int) {
        holder.onBind(list[position], allGoalsInteface)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}