package com.dbvertex.quizappnew.Presentation.MyGoalFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.ItemAllGoalsBinding
import com.dbvertex.quizappnew.databinding.ItemMygoalMainBinding

class MyGoalsAdapter(val list: List<MyGoalsDTO>, val allGoalsInteface: MyGoalsInteface) :
    RecyclerView.Adapter<MyGoalsAdapter.AllGoalsViewHolder>() {


    class AllGoalsViewHolder(val itemMygoalMainBinding: ItemMygoalMainBinding) :
        RecyclerView.ViewHolder(itemMygoalMainBinding.root) {
        fun onBind(allGoalsDTO: MyGoalsDTO, allGoalsInteface: MyGoalsInteface) {
            Glide.with(itemMygoalMainBinding.mainimg.context).load(allGoalsDTO.bg_image)
                .into(itemMygoalMainBinding.mainimg)
            Glide.with(itemMygoalMainBinding.mainimg.context).load(allGoalsDTO.icon_img)
                .into(itemMygoalMainBinding.sliderimg)
            itemMygoalMainBinding.title.text = allGoalsDTO.title.toString()

           if(allGoalsDTO.like_status==true){
               itemMygoalMainBinding.imagelike.setBackgroundResource(R.drawable.icons_heart)
               itemMygoalMainBinding.sliderimg.setBackgroundColor(R.color.green)
           }else{
               itemMygoalMainBinding.imagelike.setBackgroundResource(R.drawable.icons_heart)
           }

            itemMygoalMainBinding.root.setOnClickListener {
                allGoalsInteface.onClickSingleAllGoal(allGoalsDTO)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllGoalsViewHolder {
        val itemMygoalMainBinding = ItemMygoalMainBinding.inflate(LayoutInflater.from(parent.context))
        return AllGoalsViewHolder(itemMygoalMainBinding)
    }

    override fun onBindViewHolder(holder: AllGoalsViewHolder, position: Int) {
        holder.onBind(list[position], allGoalsInteface)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}