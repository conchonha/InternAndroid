package com.example.taskdeha.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taskdeha.ui.call.FragmentCall
import com.example.taskdeha.ui.gif.FragmentGif
import com.example.taskdeha.ui.image.FragmentImage
import com.example.taskdeha.ui.screen.FragmentScreen

class ViewPager2(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    companion object {
        val fragments = listOf(
            FragmentCall(),
            FragmentImage(),
            FragmentGif(),
            FragmentScreen()
        )
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}