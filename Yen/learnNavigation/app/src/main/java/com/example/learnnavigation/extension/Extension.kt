package com.example.learnnavigation.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Extension {
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