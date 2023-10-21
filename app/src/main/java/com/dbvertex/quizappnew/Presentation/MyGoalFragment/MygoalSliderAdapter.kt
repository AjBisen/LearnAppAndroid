package com.dbvertex.quizappnew.Presentation.MyGoalFragment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.ItemMygoalSliderBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class MygoalSliderAdapter(
    val list: List<MyGoalSliderDto>, val mygoalSliderInterface: MygoalSliderInterface
) : RecyclerView.Adapter<MygoalSliderAdapter.MygoalSliderViewHolder>() {
    var selectedPosition = -1


    inner class MygoalSliderViewHolder(val itemMygoalSliderBinding: ItemMygoalSliderBinding) :
        RecyclerView.ViewHolder(itemMygoalSliderBinding.root) {
        fun bindView(
            myGoalSliderDto: MyGoalSliderDto, mygoalSliderInterface: MygoalSliderInterface
        ) {
            itemMygoalSliderBinding.sliderText.text = myGoalSliderDto.title.toString()
            Glide.with(itemMygoalSliderBinding.sliderimg.context)
                .load(myGoalSliderDto.image.toString()).into(itemMygoalSliderBinding.sliderimg)
            itemMygoalSliderBinding.root.setOnClickListener {

                mygoalSliderInterface.onClickSingleMyGoalSlider(myGoalSliderDto)
                selectedPosition = adapterPosition
                notifyDataSetChanged()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MygoalSliderViewHolder {
        val itemMygoalSliderBinding =
            ItemMygoalSliderBinding.inflate(LayoutInflater.from(parent.context))
        return MygoalSliderViewHolder(itemMygoalSliderBinding)
    }

    override fun onBindViewHolder(holder: MygoalSliderViewHolder, position: Int) {
        holder.bindView(list[position], mygoalSliderInterface)

        if (selectedPosition == position) {
            holder.itemMygoalSliderBinding.sliderText.setTextColor(Color.GREEN)
            holder.itemMygoalSliderBinding.imgcard.setStrokeColor(Color.GREEN)
        } else {
            holder.itemMygoalSliderBinding.sliderText.setTextColor(Color.BLACK)
            holder.itemMygoalSliderBinding.imgcard.setStrokeColor(Color.BLACK)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}