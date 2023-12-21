package com.example.learnretrofit2.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.learnretrofit2.R
import com.example.learnretrofit2.adapter.SuggestedSearchAdapter
import com.example.learnretrofit2.databinding.FragmentDemoBinding
import com.example.learnretrofit2.viewmodel.ChartViewModel

class FragmentDemo : Fragment(R.layout.fragment_demo) {
    private lateinit var binding: FragmentDemoBinding

    private lateinit var viewModel: ChartViewModel
    private lateinit var adapter: SuggestedSearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDemoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SuggestedSearchAdapter(emptyList())

        viewModel = ViewModelProvider(this).get(ChartViewModel::class.java)
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
