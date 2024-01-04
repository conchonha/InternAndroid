package com.example.learnnavigation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learnnavigation.ui.fragment.FragmentAnimImage
import com.example.learnnavigation.ui.fragment.FragmentBackgroundImage
import com.example.learnnavigation.ui.fragment.FragmentRing
import com.example.learnnavigation.ui.fragment.FragmentScreenImage
import com.example.learnnavigation.utils.Const.INDEX_FRAIMAGE
import com.example.learnnavigation.utils.Const.INDEX_FRBGIMAGE
import com.example.learnnavigation.utils.Const.INDEX_FRRING
import com.example.learnnavigation.utils.Const.INDEX_FRSCREENIMAGE
import com.example.learnnavigation.utils.Const.NUMBER_FRAGMENT

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