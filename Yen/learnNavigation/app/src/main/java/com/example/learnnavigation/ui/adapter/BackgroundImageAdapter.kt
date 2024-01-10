package com.example.learnnavigation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.ItemsBackgroundImageFragmentBinding
import com.example.learnnavigation.data.model.SuggestedSearches
import com.example.learnnavigation.extension.loadImage
import com.example.learnnavigation.utils.BaseRecyclerViewAdapter

class BackgroundImageAdapter: RecyclerView.Adapter<BackgroundImageAdapter.ViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback())

    val listItem: List<SuggestedSearches>
        get() = asyncListDiffer.currentList

    fun setData(data: List<SuggestedSearches>) {
        asyncListDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsBackgroundImageFragmentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItem.getOrNull(position) ?: return)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    inner class ViewHolder(private val binding: ItemsBackgroundImageFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(suggestedSearches: SuggestedSearches) {
         //   binding.tvName.text = suggestedSearches.name
            loadImage(binding.ivThumbnail, suggestedSearches.thumbnail)
        }
    }
    private class DiffCallback : DiffUtil.ItemCallback<SuggestedSearches>() {
        override fun areItemsTheSame(
            oldItem: SuggestedSearches,
            newItem: SuggestedSearches
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: SuggestedSearches,
            newItem: SuggestedSearches
        ): Boolean {
            return oldItem == newItem
        }
    }
}
