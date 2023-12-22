package com.example.learnnavigation.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.FragmentAnimationImageBinding

 class FragmentAnimImage : BaseFragmentDataBinding<FragmentAnimationImageBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAnimationImageBinding =
        FragmentAnimationImageBinding::inflate

    override val layoutId: Int = R.layout.fragment_animation_image
}
