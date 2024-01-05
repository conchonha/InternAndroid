package com.example.taskdeha.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdeha.data.model.Language
import com.example.taskdeha.databinding.ItemLanguageBinding
import com.example.taskdeha.extension.loadDrawable
import com.example.taskdeha.utils.DiffCallback

class LanguageAdapter : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {
    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback<Language>())
    private var onItemClickListener: OnItemClickListener? = null
    private var selectedPosition = RecyclerView.NO_POSITION
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageAdapter.ViewHolder {
        val binding =
            ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(language: List<Language>) {
        asyncListDiffer.submitList(language)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    fun getLanguage(position: Int): Language = asyncListDiffer.currentList[position]
    override fun onBindViewHolder(holder: LanguageAdapter.ViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList.getOrNull(position) ?: return)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    inner class ViewHolder(private val binding: ItemLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(language: Language) {
            with(binding) {
                language.image?.let { thumbnail -> ivFlag.loadDrawable(thumbnail) }
                language.nameLanguage?.let {
                    tvLanguage.text = it
                }
                rbLanguage.isChecked = adapterPosition == selectedPosition
                rbLanguage.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        notifyItemChanged(selectedPosition)
                        selectedPosition = position
                        onItemClickListener?.onItemClick(position)
                    }
                }
            }
        }
    }
}