package com.example.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demo.R
import com.example.demo.databinding.FragmentMenuBinding
import com.example.demo.ui.adapter.ViewPager2
import com.example.demo.ui.call.FragmentCall
import com.example.demo.ui.gif.FragmentGif
import com.example.demo.ui.image.FragmentImage
import com.example.demo.ui.screen.FragmentScreen

class FragmentMenu : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentList = listOf(
            FragmentCall(),
            FragmentImage(),
            FragmentGif(),
            FragmentScreen()
        )
        val adapter = ViewPager2(requireActivity(), fragmentList)
        with(binding) {
            viewpager.adapter = adapter
            viewpager.registerOnPageChangeCallback(object :
                androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> bottomNav.menu.findItem(R.id.callFragment).isChecked = true
                        1 -> bottomNav.menu.findItem(R.id.imageFragment).isChecked = true
                        2 -> bottomNav.menu.findItem(R.id.gifFragment).isChecked = true
                        3 -> bottomNav.menu.findItem(R.id.screenFragment).isChecked = true
                    }
                }
            })
            bottomNav.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.callFragment -> viewpager.currentItem = 0
                    R.id.imageFragment -> viewpager.currentItem = 1
                    R.id.gifFragment -> viewpager.currentItem = 2
                    R.id.screenFragment -> viewpager.currentItem = 3
                }
                false
            }
        }
    }
}