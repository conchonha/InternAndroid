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

            bottomNav.setOnNavigationItemSelectedListener { item ->
                viewpager.setCurrentItem(adapter.convertPositionTabFromMenuId(item.itemId),false)
                false
            }
        }
    }
}