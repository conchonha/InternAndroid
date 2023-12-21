package com.example.demo.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.data.model.SuggestedSearches
import com.example.demo.databinding.ItemDataBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var list: MutableList<SuggestedSearches> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val binding=ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(suggestedSearches: List<SuggestedSearches>){
        list.clear()
        list.addAll(suggestedSearches)
        notifyDataSetChanged()

    }
    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestedSearches: SuggestedSearches) {
            with(binding) {
                Glide.with(binding.root)
                    .load(suggestedSearches.thumbnail)
                    .centerCrop().into(binding.ivData)
                suggestedSearches.name?.let {
                    tvName.text = it
                }
            }
        }
    }
}