package com.example.taskdeha.ui.adapter

interface OnItemClickListener<T> {
    fun onItemClick(position: Int,data: T)
}