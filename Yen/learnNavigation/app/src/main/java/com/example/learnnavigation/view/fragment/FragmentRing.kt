package com.example.learnnavigation.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.FragmentRingBinding

class FragmentRing : BaseFragmentDataBinding<FragmentRingBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRingBinding =
        FragmentRingBinding::inflate

    override val layoutId: Int = R.layout.fragment_animation_image
}

