package com.example.learnnavigation.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.learnnavigation.R
import com.example.learnnavigation.adapter.BackgroundImageAdapter
import com.example.learnnavigation.databinding.FragmentAnimationImageBinding
import com.example.learnnavigation.databinding.FragmentBackgroundImageBinding
import com.example.learnnavigation.databinding.FragmentRingBinding
import com.example.learnnavigation.model.SuggestedSearches
import com.example.learnnavigation.viewmodel.BackgroundImageViewModel
import kotlin.math.log


class FragmentBackgroundImage : BaseFragmentDataBinding<FragmentBackgroundImageBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBackgroundImageBinding =
        FragmentBackgroundImageBinding::inflate
    override val layoutId: Int = R.layout.fragment_background_image

    private lateinit var viewModel: BackgroundImageViewModel
    private val adapter by lazy { BackgroundImageAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BackgroundImageViewModel::class.java)

        with(binding) {
            recycleViewChartFragment.adapter = adapter

            viewModel.suggestedSearches.observe(viewLifecycleOwner) { suggestedSearches ->
                adapter.setData(suggestedSearches)
            }
            viewModel.fetchDataFromApi()
        }
    }
}
