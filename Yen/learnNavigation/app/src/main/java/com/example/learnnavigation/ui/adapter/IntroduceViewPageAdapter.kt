package com.example.learnnavigation.ui.adapter

import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.ItemIntroduceBinding
import com.example.learnnavigation.utils.BaseRecyclerViewAdapter
import com.example.learnnavigation.utils.getString

class IntroduceViewPageAdapter: BaseRecyclerViewAdapter<IntroduceItem, ItemIntroduceBinding>(){
    override val layoutId: Int = R.layout.item_introduce
    override fun onBindViewHolder(binding: ItemIntroduceBinding, position: Int) {
        val items = listItem.getOrNull(position) ?: return
        with(binding){
            ivIntroduce.setImageResource(items.image!!)
            tvTitleIntroduce.text = getString(items.tital!!)
        }
    }

}
data class IntroduceItem( var image: Int? = null, var tital: Int? = null)