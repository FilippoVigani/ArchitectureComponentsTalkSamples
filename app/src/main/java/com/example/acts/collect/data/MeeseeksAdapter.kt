package com.example.acts.collect.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.acts.collect.data.entities.Meeseek
import com.example.acts.databinding.ContentMeeseekItemBinding

class MeeseeksAdapter: ListAdapter<Meeseek, MeeseekViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeeseekViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MeeseekViewHolder(ContentMeeseekItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: MeeseekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffCallback: DiffUtil.ItemCallback<Meeseek>() {
        override fun areItemsTheSame(oldItem: Meeseek, newItem: Meeseek) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Meeseek, newItem: Meeseek) = oldItem == newItem

    }
}