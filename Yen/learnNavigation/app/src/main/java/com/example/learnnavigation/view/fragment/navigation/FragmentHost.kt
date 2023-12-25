package com.example.learnnavigation.view.fragment.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.learnnavigation.Const.INDEX_FRAIMAGE
import com.example.learnnavigation.Const.INDEX_FRBGIMAGE
import com.example.learnnavigation.Const.INDEX_FRRING
import com.example.learnnavigation.Const.INDEX_FRSCREENIMAGE
import com.example.learnnavigation.R
import com.example.learnnavigation.adapter.ViewPage2Adapter
import com.example.learnnavigation.databinding.FragmentAnimationImageBinding
import com.example.learnnavigation.databinding.FragmentHostBinding
import com.example.learnnavigation.view.fragment.BaseFragmentDataBinding

 class FragmentHost : BaseFragmentDataBinding<FragmentHostBinding>() {

     override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHostBinding =
         FragmentHostBinding::inflate

     override val layoutId: Int = R.layout.fragment_animation_image

     private val adapter by lazy { ViewPage2Adapter(this) }
    private val viewPage2 by lazy { binding.viewPage2 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupViewPager() {
        with(viewPage2) {
            adapter = this@FragmentHost.adapter
            isSaveEnabled = true
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNav.menu.getItem(position).isChecked = true
                }
            })
        }
    }

    private fun setupBottomNavigationView() {
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            val currentItem = when (menuItem.itemId) {
                R.id.frRing -> INDEX_FRRING
                R.id.frBackgroundImage -> INDEX_FRBGIMAGE
                R.id.frAnimImage -> INDEX_FRAIMAGE
                R.id.frScreenImage -> INDEX_FRSCREENIMAGE
                else -> return@setOnItemSelectedListener false
            }
            viewPage2.currentItem = currentItem
            true
        }
    }

}