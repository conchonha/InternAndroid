package com.example.demo.ui.call

import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.demo.R
import com.example.demo.base.BaseFragment
import com.example.demo.data.api.ApiInterface
import com.example.demo.databinding.FragmentCallBinding
import com.example.demo.ui.adapter.ItemAdapter

class FragmentCall : BaseFragment<FragmentCallBinding>() {
    override val layoutId: Int = R.layout.fragment_call

        private val viewModel: CallViewModel by viewModels()
    private lateinit var adapter: ItemAdapter

    //    private val adapter by lazy { ItemAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemAdapter()
        initViewModel()
        viewModel.getData()
        with(binding) {
            recyclerview.adapter = adapter
        }

    }

    private fun initViewModel() {
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
        viewModel.message.observe(viewLifecycleOwner){
            AlertDialog.Builder(context)
                .setCancelable(true)
                .setMessage(it.toString())
                .setTitle(null)
                .setPositiveButton("Close"){dialog,_ ->
                    dialog.cancel()
                    requireActivity().finish()
                }
                .show()
        }
    }
}