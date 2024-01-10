package com.example.taskdeha.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

//class DiffCallback : DiffUtil.ItemCallback<SuggestedSearches>() {
//    override fun areItemsTheSame(oldItem: SuggestedSearches, newItem: SuggestedSearches): Boolean {
//        return oldItem.name == newItem.name
//    }
//
//    override fun areContentsTheSame(
//        oldItem: SuggestedSearches,
//        newItem: SuggestedSearches
//    ): Boolean {
//        return oldItem == newItem
//    }
//}


class DiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: T,
        newItem: T
    ): Boolean {
        return oldItem == newItem
    }
}