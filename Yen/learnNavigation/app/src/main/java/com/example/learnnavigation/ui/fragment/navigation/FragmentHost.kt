package com.example.learnnavigation.ui.fragment.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.learnnavigation.utils.Const.INDEX_FRAIMAGE
import com.example.learnnavigation.utils.Const.INDEX_FRBGIMAGE
import com.example.learnnavigation.utils.Const.INDEX_FRRING
import com.example.learnnavigation.utils.Const.INDEX_FRSCREENIMAGE
import com.example.learnnavigation.R
import com.example.learnnavigation.ui.adapter.ViewPage2Adapter
import com.example.learnnavigation.databinding.FragmentHostBinding
import com.example.learnnavigation.ui.activity.MainActivity
import com.example.learnnavigation.ui.fragment.BaseFragmentDataBinding
import com.example.learnnavigation.ui.viewmodel.HostViewModel

class FragmentHost : BaseFragmentDataBinding<FragmentHostBinding, HostViewModel>() {
    override val layoutId: Int = R.layout.fragment_host
    override val vm: HostViewModel by viewModels()

     private val adapter by lazy { ViewPage2Adapter(this) }
    private val viewPage2 by lazy { binding.viewPage2 }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupBottomNavigationView()
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.viewPage2.isUserInputEnabled = false;
    }

    private fun setupViewPager() {
        with(viewPage2) {
            adapter = this@FragmentHost.adapter
            isSaveEnabled = true
            offscreenPageLimit = 4 //khoi tao dong thoi
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    val title = when (position) {
                        INDEX_FRRING -> resources.getString(R.string.Ring)
                        INDEX_FRBGIMAGE -> resources.getString(R.string.BgImage)
                        INDEX_FRAIMAGE -> resources.getString(R.string.AnimImage)
                        INDEX_FRSCREENIMAGE -> resources.getString(R.string.ScreenImage)
                        else -> ""
                    }
                    (activity as MainActivity).setToolbarTitle(title)
                    binding.bottomNav.menu.getItem(position).isChecked = true
                }
            })
        }
    }

    private fun setupBottomNavigationView() {
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            val currentItem = when (menuItem.itemId) {
                R.id.lbl_Ring -> INDEX_FRRING
                R.id.lbl_BackgroundImage -> INDEX_FRBGIMAGE
                R.id.lbl_AnimImage -> INDEX_FRAIMAGE
                R.id.lbl_ScreenImage -> INDEX_FRSCREENIMAGE
                else -> return@setOnItemSelectedListener false
            }
            viewPage2.currentItem = currentItem
            true
        }
    }


}