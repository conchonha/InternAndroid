package com.example.learnnavigation.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.learnnavigation.R
import com.example.learnnavigation.adapter.BackgroundImageAdapter
import com.example.learnnavigation.databinding.FragmentBackgroundImageBinding

import com.example.learnnavigation.viewmodel.BackgroundImageViewModel


class FragmentBackgroundImage : BaseFragmentDataBinding<FragmentBackgroundImageBinding>() {

    override val layoutId: Int = R.layout.fragment_background_image

    private val viewModel: BackgroundImageViewModel by viewModels()
    private val adapter by lazy { BackgroundImageAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recycleViewChartFragment.adapter = adapter

            viewModel.suggestedSearches.observe(viewLifecycleOwner) { suggestedSearches ->
                adapter.setData(suggestedSearches)
            }
            viewModel.fetchDataFromApi()
        }
    }
}
