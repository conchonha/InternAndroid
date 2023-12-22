package com.example.learnnavigation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learnnavigation.Const.INDEX_FRAIMAGE
import com.example.learnnavigation.Const.INDEX_FRBGIMAGE
import com.example.learnnavigation.Const.INDEX_FRRING
import com.example.learnnavigation.Const.INDEX_FRSCREENIMAGE
import com.example.learnnavigation.Const.NUMBER_FRAGMENT
import com.example.learnnavigation.view.fragment.FragmentAnimImage
import com.example.learnnavigation.view.fragment.FragmentBackgroundImage
import com.example.learnnavigation.view.fragment.FragmentRing
import com.example.learnnavigation.view.fragment.FragmentScreenImage

 class ViewPage2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = NUMBER_FRAGMENT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            INDEX_FRRING -> FragmentRing()
            INDEX_FRBGIMAGE -> FragmentBackgroundImage()
            INDEX_FRAIMAGE -> FragmentAnimImage()
            INDEX_FRSCREENIMAGE-> FragmentScreenImage()
            else -> throw Throwable("Invalid position $position")
        }
    }
}