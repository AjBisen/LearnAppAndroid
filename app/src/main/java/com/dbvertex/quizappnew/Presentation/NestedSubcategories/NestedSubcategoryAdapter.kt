package com.dbvertex.quizappnew.Presentation.NestedSubcategories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dbvertex.quizappnew.databinding.ItemAllgoalsSubcategoryBinding

class NestedSubcategoryAdapter(val list: List<NestedCategoryDTO>, val allGoalsInteface: NestedSubcategoryInteface) :
    RecyclerView.Adapter<NestedSubcategoryAdapter.AllGoalsViewHolder>() {


    class AllGoalsViewHolder(val itemAllgoalsSubcategoryBinding: ItemAllgoalsSubcategoryBinding) :
        RecyclerView.ViewHolder(itemAllgoalsSubcategoryBinding.root) {
        fun onBind(allGoalsDTO: NestedCategoryDTO, allGoalsInteface: NestedSubcategoryInteface) {
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