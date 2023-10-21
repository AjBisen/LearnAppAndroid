package com.dbvertex.quizappnew.Presentation.Playfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.dbvertex.quizappnew.databinding.ItemPlayBinding

class PlayAdapter(val list: List<PlayDTO>,val playInterface: PlayInterface): RecyclerView.Adapter<PlayAdapter.Playviewholder>() {



    class Playviewholder(val itemPlayBinding: ItemPlayBinding):ViewHolder(itemPlayBinding.root){
        fun onBind(playDTO: PlayDTO,playInterface: PlayInterface){

           Glide.with(itemPlayBinding.playimg.context).load(playDTO.image.toString()).into(itemPlayBinding.playimg)
            itemPlayBinding.playTitle.text=playDTO.title.toString()
            itemPlayBinding.root.setOnClickListener {
                playInterface.onPlayItemclick(playDTO)
            }
            itemPlayBinding.playTitle.setSelected(true);

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Playviewholder {
        val itemPlayBinding=ItemPlayBinding.inflate(LayoutInflater.from(parent.context))
        return  Playviewholder(itemPlayBinding)
    }

    override fun onBindViewHolder(holder: Playviewholder, position: Int) {
        holder.onBind(list[position],playInterface)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}