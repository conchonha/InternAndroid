package com.example.learnnavigation.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<T : Any, VB : ViewBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder<VB>>() {
    protected var items = AsyncListDiffer(this, DiffCallback<T>())

    open fun updateItems(items: List<T>) {
        this.items.submitList(items)
    }

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun getItemCount() = items.currentList.count()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseViewHolder<VB>(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )

    open override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        onBindViewHolder(holder.binding, position)
    }
    abstract fun onBindViewHolder(binding: VB, position: Int)

    val listItem: List<T>
        get() = items.currentList

    class BaseViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
}