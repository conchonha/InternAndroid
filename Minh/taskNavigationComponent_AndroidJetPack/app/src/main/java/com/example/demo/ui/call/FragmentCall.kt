package com.example.demo.ui.call

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.demo.R
import com.example.demo.databinding.FragmentCallBinding
import com.example.demo.ui.adapter.ItemAdapter

class FragmentCall : Fragment() {

    companion object {
        fun newInstance() = FragmentCall()
    }

    private lateinit var viewModel: CallViewModel
    private lateinit var binding:FragmentCallBinding
    private lateinit var adapter:ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this)[CallViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCallBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter=ItemAdapter()
        initViewModel()
        viewModel.getData()
        with(binding){
            recyclerview.adapter=adapter
            recyclerview.layoutManager=GridLayoutManager(context, 3)
        }
    }

    private fun initViewModel() {
        viewModel.data.observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}