package com.example.learnnavigation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
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

    override fun onBindViewHolder(binding: ItemsChangeLanguageBinding, position: Int) {
        val languages = listItem.getOrNull(position) ?: return

        with(binding){
            ivFlag.setImageResource(languages.image)
            tvCountry.text = languages.name

            cbChooseLanguage.setOnClickListener {
                resetState()
                iActionClick.onClickItem(position = position,languages,callback = {
                    notifyItemChanged(position)
                })
            }
        }
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

//class LanguageCountryAdapter: RecyclerView.Adapter<LanguageCountryAdapter.LanguageCountryViewHolder>(){
//    val listItem = AsyncListDiffer(this,DIFFCA)
//    var selectedPosition = -1
//    var isLanguageName = ""
//
//    fun submit(languages: List<languageCountry>){
//
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageCountryViewHolder {
//       val binding = ItemsChangeLanguageBinding.inflate(
//           LayoutInflater.from(parent.context),
//           parent,
//           false
//       )
//        return LanguageCountryViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//       return languages.size
//    }
//
//    override fun onBindViewHolder(holder: LanguageCountryViewHolder, position: Int) {
//        holder.bind(languages[position])
//    }
//
//    inner class LanguageCountryViewHolder(private val binding: ItemsChangeLanguageBinding)
//        : RecyclerView.ViewHolder(binding.root) {
//        @SuppressLint("NotifyDataSetChanged")
//        fun bind(languages: languageCountry){
//            with(binding){
//                ivFlag.setImageResource(languages.image)
//                tvCountry.text = languages.name
//                cbChooseLanguage.isChecked = adapterPosition == selectedPosition
//
//                cbChooseLanguage.setOnClickListener {
//                    val currentPosition = adapterPosition
//                    if (selectedPosition == currentPosition) {
//                        selectedPosition = -1
//                        notifyItemChanged(currentPosition)
//                        isLanguageName = languages.name
//                    } else {
//                        val previousPosition = selectedPosition
//                        selectedPosition = currentPosition
//                        if (previousPosition != -1) {
//                            notifyItemChanged(previousPosition)
//                        }
//                        notifyItemChanged(currentPosition)
//                        isLanguageName = languages.name
//                    }
//                    isLanguage.invoke(isLanguageName)
//                }
//            }
//        }
//    }
//}
