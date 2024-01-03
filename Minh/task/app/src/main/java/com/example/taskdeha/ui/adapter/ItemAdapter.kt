package com.example.taskdeha.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdeha.data.model.Drink
import com.example.taskdeha.data.model.SuggestedSearches
import com.example.taskdeha.data.model.url2.Product
import com.example.taskdeha.databinding.ItemDataBinding
import com.example.taskdeha.extension.load
import com.example.taskdeha.utils.DiffCallback

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var list: MutableList<Product> = mutableListOf()
    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback<SuggestedSearches>())
    private val asyncListDifferDrinks = AsyncListDiffer(this, DiffCallback<Drink>())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun updateDrink(data:List<Drink>){
        asyncListDifferDrinks.submitList(data)
    }

    fun updateData(data: List<SuggestedSearches>) {
        asyncListDiffer.submitList(data)
    }


    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        if (asyncListDifferDrinks.currentList.size > 0) {
            holder.bindDrink(asyncListDifferDrinks.currentList.getOrNull(position) ?: return)
        } else {
            holder.bind(asyncListDiffer.currentList.getOrNull(position) ?: return)
        }
    }

    override fun getItemCount(): Int =
        if (asyncListDiffer.currentList.size > 0) asyncListDiffer.currentList.size else asyncListDifferDrinks.currentList.size

    inner class ViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestedSearches: SuggestedSearches) {
            with(binding) {
                suggestedSearches.thumbnail?.let { thumbnail -> ivData.load(thumbnail) }
                suggestedSearches.name?.let {
                    tvName.text = it
                }
            }
        }

        fun bindDrink(drink: Drink) {
            with(binding) {
                drink.strDrinkThumb?.let { thumbnail -> ivData.load(thumbnail) }
                drink.strDrink?.let { name -> tvName.text = name }
            }
        }
    }
}