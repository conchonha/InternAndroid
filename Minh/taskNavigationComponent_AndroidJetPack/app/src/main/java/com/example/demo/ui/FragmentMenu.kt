package com.example.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demo.R
import com.example.demo.databinding.FragmentMenuBinding
import com.example.demo.ui.adapter.ViewPager2
import com.example.demo.utils.Const

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
        val adapter = ViewPager2(requireActivity())
        with(binding) {
            viewpager.adapter = adapter
            binding.viewpager.isUserInputEnabled = false
            viewpager.registerOnPageChangeCallback(object :
                androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        Const.ZERO -> bottomNav.menu.findItem(R.id.callFragment).isChecked = true
                        Const.ONE -> bottomNav.menu.findItem(R.id.imageFragment).isChecked = true
                        Const.TWO -> bottomNav.menu.findItem(R.id.gifFragment).isChecked = true
                        Const.THREE -> bottomNav.menu.findItem(R.id.screenFragment).isChecked = true
                    }
                }
            })
            bottomNav.setOnNavigationItemSelectedListener { item ->
                val position = when (item.itemId) {
                    R.id.callFragment -> Const.ZERO
                    R.id.imageFragment -> Const.ONE
                    R.id.gifFragment -> Const.TWO
//                    R.id.screenFragment -> viewpager.currentItem = 3
                    else -> Const.THREE
                }
                viewpager.currentItem = position
                false
            }
        }
    }
}