package com.example.taskdeha.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdeha.data.model.Language
import com.example.taskdeha.databinding.ItemLanguageBinding
import com.example.taskdeha.extension.load
import com.example.taskdeha.utils.DiffCallback

class LanguageAdapter : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {
    private var list: MutableList<Language> = mutableListOf()
    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback())
    private var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageAdapter.ViewHolder {
        val binding =
            ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(product: List<Language>) {
        list.clear()
        list.addAll(product)
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: LanguageAdapter.ViewHolder, position: Int) {
        holder.bind(list.getOrNull(position) ?: return)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    fun getLanguage(position: Int): Language = list[position]
    override fun getItemCount(): Int =
        if (asyncListDiffer.currentList.size > 0) asyncListDiffer.currentList.size else list.size

    inner class ViewHolder(private val binding: ItemLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(language: Language) {
            with(binding) {
//                Glide.with(binding.root)
//                    .load(suggestedSearches.thumbnail)
//                    .centerCrop().into(binding.ivData)
                language.image?.let { thumbnail -> ivFlag.load(thumbnail) }
                language.nameLanguage?.let {
                    tvLanguage.text = it
                }
                constrainLanguage.setOnClickListener {
                    rbLanguage.isChecked = true
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        onItemClickListener?.onItemClick(position)
                    }

                }
            }
        }
    }
}