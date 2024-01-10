package com.example.taskdeha.ui.adapter

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdeha.data.model.Introduce
import com.example.taskdeha.data.model.SuggestedSearches
import com.example.taskdeha.databinding.ItemDataBinding
import com.example.taskdeha.databinding.ItemIntroduceBinding
import com.example.taskdeha.extension.load
import com.example.taskdeha.extension.loadDrawable
import com.example.taskdeha.utils.DiffCallback

class IntroduceAdapter : RecyclerView.Adapter<IntroduceAdapter.ViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, DiffCallback<Introduce>())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemIntroduceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    fun updateData(introduce: List<Introduce>) {
        asyncListDiffer.submitList(introduce)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList.getOrNull(position) ?: return)
    }

    inner class ViewHolder(private val binding: ItemIntroduceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(introduce: Introduce) {
            with(binding) {
//                introduce.image?.let { ivIntroduce.loadDrawable(it) }
                tvTitleIntroduce.text = introduce.title
                tvMessageIntroduce.text = introduce.message

                val bitmap = (ivIntroduce.drawable as? BitmapDrawable)?.bitmap ?: return
                val scaleBitmap = Bitmap.createScaledBitmap(bitmap,479,634,false)
                ivIntroduce.setImageBitmap(scaleBitmap)

            }
        }
    }
}