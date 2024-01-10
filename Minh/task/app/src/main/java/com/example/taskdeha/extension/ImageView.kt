package com.example.taskdeha.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}
fun ImageView.loadDrawable(url:Int){
    Glide.with(this)
        .load(url)
        .into(this)
}