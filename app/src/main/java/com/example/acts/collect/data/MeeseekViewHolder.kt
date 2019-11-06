package com.example.acts.collect.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.acts.collect.data.entities.Meeseek
import com.example.acts.databinding.ContentMeeseekItemBinding

class MeeseekViewHolder(private val binding: ContentMeeseekItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(meeseek: Meeseek){
        binding.meeseek = meeseek
        binding.executePendingBindings()
    }
}