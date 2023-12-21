package com.example.learnretrofit2.view.fragment.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.learnretrofit2.R
import com.example.learnretrofit2.adapter.ViewPage2Adapter
import com.example.learnretrofit2.databinding.FragmentHostBinding
import com.example.learnretrofit2.view.fragment.FragmentDemo
import com.example.learnretrofit2.view.fragment.FragmentGlobal
import com.example.learnretrofit2.view.fragment.FragmentHeart
import com.example.learnretrofit2.view.fragment.FragmentLocation

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
            Pair(FragmentDemo(), 0),
            Pair(FragmentLocation(), 1),
            Pair(FragmentHeart(), 2),
            Pair(FragmentGlobal(), 3)
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
                R.id.demoFragment -> binding.viewPage2.currentItem = 0
                R.id.locationFragment -> binding.viewPage2.currentItem = 1
                R.id.heartFragment2 -> binding.viewPage2.currentItem = 2
                R.id.globalFragment -> binding.viewPage2.currentItem = 3
            }
            true
        }
    }
}
