package com.example.learnnavigation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.learnnavigation.model.SuggestedSearches
import com.example.learnnavigation.databinding.ItemsRingFragmentBinding


class BackgroundImageAdapter(private var suggestedSearches: List<SuggestedSearches>) :
    RecyclerView.Adapter<BackgroundImageAdapter.ViewHolder>() {

    fun setData(data: List<SuggestedSearches>) {
        suggestedSearches = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemsRingFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suggestedSearch = suggestedSearches.getOrNull(position) ?: return
        holder.bind(suggestedSearch)
    }

    override fun getItemCount(): Int {
        return suggestedSearches.size
    }

    inner class ViewHolder(private val binding: ItemsRingFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(suggestedSearches: SuggestedSearches) {
            binding.tvName.text = suggestedSearches.name
            loadImage(binding.ivThumbnail, suggestedSearches.thumbnail)
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