package com.example.learnretrofit2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.learnretrofit2.model.SuggestedSearches
import com.example.learnretrofit2.databinding.ItemsChartFragmentBinding


class SuggestedSearchAdapter(private var suggestedSearches: List<SuggestedSearches>) :
    RecyclerView.Adapter<SuggestedSearchAdapter.ViewHolder>() {

    fun setData(data: List<SuggestedSearches>) {
        suggestedSearches = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemsChartFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suggestedSearch = suggestedSearches.getOrNull(position) ?: return
        holder.bind(suggestedSearch)
    }

    override fun getItemCount(): Int {
        return suggestedSearches.size
    }

    inner class ViewHolder(private val binding: ItemsChartFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(suggestedSearches: SuggestedSearches) {
            binding.textViewName.text = suggestedSearches.name
            loadImage(binding.imageViewThumbnail, suggestedSearches.thumbnail)
        }
    }
    companion object {
        @BindingAdapter("image_url")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            if (!imageUrl.isNullOrEmpty()) {
                Glide.with(view.context)
                    .load(imageUrl)
                    .into(view)
            }
        }
    }

}