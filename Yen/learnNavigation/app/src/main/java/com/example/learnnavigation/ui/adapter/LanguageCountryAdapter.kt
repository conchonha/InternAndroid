package com.example.learnnavigation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnnavigation.data.model.languageCountry
import com.example.learnnavigation.databinding.ItemsChangeLanguageBinding

class LanguageCountryAdapter(
    private val languages: List<languageCountry>,
    private var isLanguage: (String) -> Unit):
    RecyclerView.Adapter<LanguageCountryAdapter.LanguageCountryViewHolder>(){

    var selectedPosition = -1
    var isLanguageName = ""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageCountryViewHolder {
       val binding = ItemsChangeLanguageBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
        return LanguageCountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return languages.size
    }

    override fun onBindViewHolder(holder: LanguageCountryViewHolder, position: Int) {
        holder.bind(languages[position])
    }

    inner class LanguageCountryViewHolder(private val binding: ItemsChangeLanguageBinding)
        : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun bind(languages: languageCountry){
            with(binding){
                ivFlag.setImageResource(languages.image)
                tvCountry.text = languages.name
                cbChooseLanguage.isChecked = adapterPosition == selectedPosition

                cbChooseLanguage.setOnClickListener {
                    val currentPosition = adapterPosition
                    if (selectedPosition == currentPosition) {
                        selectedPosition = -1
                        notifyItemChanged(currentPosition)
                        isLanguageName = languages.name
                    } else {
                        val previousPosition = selectedPosition
                        selectedPosition = currentPosition
                        if (previousPosition != -1) {
                            notifyItemChanged(previousPosition)
                        }
                        notifyItemChanged(currentPosition)
                        isLanguageName = languages.name
                    }
                    isLanguage.invoke(isLanguageName)
                }
            }
        }
    }
}
