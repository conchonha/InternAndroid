package com.example.taskdeha.ui.screen

import androidx.fragment.app.viewModels
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.databinding.FragmentGifBinding
import com.example.taskdeha.ui.gif.GifViewModel

class FragmentScreen  : BaseFragment<FragmentGifBinding, GifViewModel>() {
    override val layoutId: Int = R.layout.fragment_screen
    override val viewModel: GifViewModel by viewModels()

}