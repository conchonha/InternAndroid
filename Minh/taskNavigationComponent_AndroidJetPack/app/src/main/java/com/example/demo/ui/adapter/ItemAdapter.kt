package com.example.demo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.data.model.SuggestedSearches
import com.example.demo.databinding.ItemDataBinding
import com.example.demo.extension.load
import com.example.demo.utils.DiffCallback

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    //    private var list: MutableList<SuggestedSearches> = mutableListOf()
    private var list: List<SuggestedSearches> = listOf()
    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun setData(suggestedSearches: List<SuggestedSearches>){
//        list.clear()
//        list.addAll(suggestedSearches)
//        notifyDataSetChanged()
//
//    }

    fun updateData(data: List<SuggestedSearches>) {
        asyncListDiffer.submitList(data)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList.getOrNull(position) ?: return)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    inner class ViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestedSearches: SuggestedSearches) {
            with(binding) {
//                Glide.with(binding.root)
//                    .load(suggestedSearches.thumbnail)
//                    .centerCrop().into(binding.ivData)
                suggestedSearches.thumbnail?.let { ivData.load(it) }
                suggestedSearches.name?.let {
                    tvName.text = it
                }
            }
        }
    }
}