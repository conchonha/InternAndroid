package com.example.learnnavigation.view.fragment.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.learnnavigation.R
import com.example.learnnavigation.adapter.ViewPage2Adapter
import com.example.learnnavigation.databinding.FragmentHostBinding
import com.example.learnnavigation.view.fragment.FragmentAnimation
import com.example.learnnavigation.view.fragment.FragmentRing
import com.example.learnnavigation.view.fragment.FragmentBackgroundImage
import com.example.learnnavigation.view.fragment.FragmentScreen

class FragmentHost : Fragment(R.layout.fragment_host) {

    private lateinit var binding: FragmentHostBinding
    private lateinit var adapter: ViewPage2Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupViewPager() {
        val fragmentList = arrayListOf(
            Pair(FragmentRing(), 0),
            Pair(FragmentBackgroundImage(), 1),
            Pair(FragmentAnimation(), 2),
            Pair(FragmentScreen(), 3)
        )
        adapter = ViewPage2Adapter(fragmentList, childFragmentManager, lifecycle)
        with(binding.viewPage2) {
            adapter = this@FragmentHost.adapter
            offscreenPageLimit = fragmentList.size - 1
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
            when (menuItem.itemId) {
                R.id.frRing -> binding.viewPage2.currentItem = 0
                R.id.frBackgroundImage -> binding.viewPage2.currentItem = 1
                R.id.frAnimation -> binding.viewPage2.currentItem = 2
                R.id.frScreen -> binding.viewPage2.currentItem = 3
            }
            true
        }
    }
}
