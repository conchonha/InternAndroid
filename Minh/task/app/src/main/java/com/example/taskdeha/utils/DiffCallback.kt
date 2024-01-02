package com.example.taskdeha.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.taskdeha.data.model.SuggestedSearches

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


data class hjdsafhj(){
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}

class Lklk{
    val id: Int = 0
    val name = "ldksfl"
    override fun hashCode(): Int {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if(other is Lklk){
            return name == other.name
        }
       return false
    }
}