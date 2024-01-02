package com.example.taskdeha.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdeha.data.model.SuggestedSearches
import com.example.taskdeha.data.model.url2.Product
import com.example.taskdeha.databinding.ItemDataBinding
import com.example.taskdeha.extension.load
import com.example.taskdeha.utils.DiffCallback


abstract class Base<VH: RecyclerView.ViewHolder, T>: RecyclerView.Adapter<VH>(){
    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback<T>())

    fun updateData(data: List<T>?) {
        asyncListDiffer.submitList(data)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size


}

abstract class CreateViewHolder<VB: ViewDataBinding>(val binding: VB): RecyclerView.ViewHolder(binding.root){
    abstract fun bind(position: Int)
}

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    //    private var list: MutableList<SuggestedSearches> = mutableListOf()
    private var list: MutableList<Product> = mutableListOf()
    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback<Product>())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(product: List<Product>) {
        list.clear()
        list.addAll(product)
        notifyDataSetChanged()

    }

    fun updateData(data: List<SuggestedSearches>?) {
        asyncListDiffer.submitList(data)
    }


    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        if (list.size > 0) {
            holder.bindDrink(list.getOrNull(position) ?: return)
        } else {
            holder.bind(asyncListDiffer.currentList.getOrNull(position) ?: return)
        }
    }

    override fun getItemCount(): Int =
        if (asyncListDiffer.currentList.size > 0) asyncListDiffer.currentList.size else list.size

    inner class ViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestedSearches: SuggestedSearches) {
            with(binding) {
//                Glide.with(binding.root)
//                    .load(suggestedSearches.thumbnail)
//                    .centerCrop().into(binding.ivData)
                suggestedSearches.thumbnail?.let { thumbnail -> ivData.load(thumbnail) }
                suggestedSearches.name?.let {
                    tvName.text = it
                }
            }
        }

        fun bindDrink(product: Product) {
            with(binding) {
                product.thumbnail?.let { thumbnail -> ivData.load(thumbnail) }
                product.name?.let { name -> tvName.text = name }
            }
        }
    }
}