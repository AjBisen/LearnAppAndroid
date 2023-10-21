package com.dbvertex.quizappnew.Presentation.Allgoals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dbvertex.quizappnew.databinding.ItemAllGoalsBinding

class AllGoalsAdapter(val list: List<AllGoalsDTO>, val allGoalsInteface: AllGoalsInteface) :
    RecyclerView.Adapter<AllGoalsAdapter.AllGoalsViewHolder>() {


    class AllGoalsViewHolder(val itemAllGoalsBinding: ItemAllGoalsBinding) :
        RecyclerView.ViewHolder(itemAllGoalsBinding.root) {
        fun onBind(allGoalsDTO: AllGoalsDTO, allGoalsInteface: AllGoalsInteface) {
            Glide.with(itemAllGoalsBinding.img1.context).load(allGoalsDTO.image)
                .into(itemAllGoalsBinding.img1)
            itemAllGoalsBinding.headline.text = allGoalsDTO.title.toString()
            itemAllGoalsBinding.root.setOnClickListener {
                allGoalsInteface.onClickSingleAllGoal(allGoalsDTO)
            }
            itemAllGoalsBinding.categoryName.text=allGoalsDTO.category_name.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllGoalsViewHolder {
        val itemAllGoalsBinding = ItemAllGoalsBinding.inflate(LayoutInflater.from(parent.context))
        return AllGoalsViewHolder(itemAllGoalsBinding)
    }

    override fun onBindViewHolder(holder: AllGoalsViewHolder, position: Int) {
        holder.onBind(list[position], allGoalsInteface)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}