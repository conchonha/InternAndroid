package com.example.learnnavigation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.learnnavigation.databinding.ItemsBackgroundImageFragmentBinding
import com.example.learnnavigation.data.model.Drinks
import com.example.learnnavigation.extension.loadImage

class AnimImageAdapter : RecyclerView.Adapter<AnimImageAdapter.ViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback())
    val listItem: List<Drinks>
        get() = asyncListDiffer.currentList

    fun setData(data: List<Drinks>) {
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

        fun bind(drinks: Drinks) {
         //   binding.tvName.text = drinks.strDrink
            loadImage(binding.ivThumbnail, drinks.strDrinkThumb)
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Drinks>() {
        override fun areItemsTheSame(
            oldItem: Drinks,
            newItem: Drinks
        ): Boolean {
            return oldItem.strDrink == newItem.strDrink
        }
        override fun areContentsTheSame(
            oldItem: Drinks,
            newItem: Drinks
        ): Boolean {
            return oldItem == newItem
        }
    }
}
