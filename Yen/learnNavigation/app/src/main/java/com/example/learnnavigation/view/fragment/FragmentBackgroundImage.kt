package com.example.learnnavigation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.learnnavigation.R
import com.example.learnnavigation.adapter.BackgroundImageAdapter
import com.example.learnnavigation.databinding.FragmentBackgroundImageBinding
import com.example.learnnavigation.viewmodel.BackgroundImageViewModel


class FragmentBackgroundImage : Fragment(R.layout.fragment_background_image) {
    private lateinit var binding: FragmentBackgroundImageBinding

    private lateinit var viewModel: BackgroundImageViewModel
    private lateinit var adapter: BackgroundImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBackgroundImageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BackgroundImageAdapter(emptyList())

        viewModel = ViewModelProvider(this).get(BackgroundImageViewModel::class.java)
        with(binding) {
            val layoutManager = GridLayoutManager(requireContext(), 3)
            recycleViewChartFragment.layoutManager = layoutManager
            recycleViewChartFragment.adapter = adapter

            viewModel.suggestedSearches.observe(viewLifecycleOwner) { suggestedSearches ->
                adapter.setData(suggestedSearches)
            }
            viewModel.fetchDataFromApi()
        }
    }
}