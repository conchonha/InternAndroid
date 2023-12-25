package com.example.demo.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.demo.data.model.SuggestedSearches

class DiffCallback : DiffUtil.ItemCallback<SuggestedSearches>() {
    override fun areItemsTheSame(oldItem: SuggestedSearches, newItem: SuggestedSearches): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: SuggestedSearches,
        newItem: SuggestedSearches
    ): Boolean {
        return oldItem == newItem
    }
}
