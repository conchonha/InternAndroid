package com.example.learnnavigation.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.FragmentRingBinding
import com.example.learnnavigation.databinding.FragmentScreenImageBinding

 class FragmentScreenImage: BaseFragmentDataBinding<FragmentScreenImageBinding>() {

     override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScreenImageBinding =
         FragmentScreenImageBinding::inflate
    override val layoutId: Int =R.layout.fragment_screen_image

}