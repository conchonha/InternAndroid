package com.example.learnnavigation.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import com.example.learnnavigation.R
import com.example.learnnavigation.data.model.languageCountry
import com.example.learnnavigation.databinding.ItemsChangeLanguageBinding
import com.example.learnnavigation.utils.BaseRecyclerViewAdapter

typealias CallBackVoid = (()->Unit)?
interface IActionClick{
    fun onClickItem(position: Int,data: languageCountry, callback: CallBackVoid)
}

class LanguageAdapter(private val iActionClick: IActionClick) : BaseRecyclerViewAdapter<languageCountry,ItemsChangeLanguageBinding>(){
    override val layoutId: Int = R.layout.items_change_language
    private var selectedPosition: Int? = null
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(binding: ItemsChangeLanguageBinding, @SuppressLint("RecyclerView") position: Int) {
        val languages = listItem.getOrNull(position) ?: return
        with(binding){
            ivFlag.setImageResource(languages.image)
            tvCountry.text = languages.name

            cbChooseLanguage.isChecked = position == selectedPosition

            cbChooseLanguage.setOnClickListener {
                selectedPosition = position
                resetState()
                iActionClick.onClickItem(position = position, languages ,callback = {
                    notifyItemChanged(position)
                })
            }
        }
        Log.d("YEN123", languages.toString())
    }
    private fun resetState(){
        listItem.forEachIndexed {index, e->
            if (e.isChecked){
                e.isChecked = false
                notifyItemChanged(index)
            }
        }
    }
}
