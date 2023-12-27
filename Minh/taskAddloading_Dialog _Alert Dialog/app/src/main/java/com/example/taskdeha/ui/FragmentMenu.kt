package com.example.taskdeha.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskdeha.R
import com.example.taskdeha.databinding.FragmentMenuBinding
import com.example.taskdeha.ui.adapter.ViewPager2
import com.example.taskdeha.utils.Const

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
                        Const.INDEX_0 -> bottomNav.menu.findItem(R.id.callFragment).isChecked = true
                        Const.INDEX_1 -> bottomNav.menu.findItem(R.id.imageFragment).isChecked = true
                        Const.INDEX_2 -> bottomNav.menu.findItem(R.id.gifFragment).isChecked = true
                        Const.INDEX_3-> bottomNav.menu.findItem(R.id.screenFragment).isChecked = true
                    }
                }
            })
            bottomNav.setOnNavigationItemSelectedListener { item ->
                val position = when (item.itemId) {
                    R.id.callFragment -> Const.INDEX_0
                    R.id.imageFragment -> Const.INDEX_1
                    R.id.gifFragment -> Const.INDEX_2
//                    R.id.screenFragment -> viewpager.currentItem = 3
                    else -> Const.INDEX_3
                }
                viewpager.currentItem = position
                false
            }
        }
    }
}