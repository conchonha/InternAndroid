package com.example.taskdeha.ui.image

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.databinding.FragmentGifBinding
import com.example.taskdeha.ui.gif.GifViewModel

class FragmentImage : BaseFragment<FragmentGifBinding, GifViewModel>() {
    override val layoutId: Int = R.layout.fragment_image

    override val viewModel: GifViewModel by viewModels()
}