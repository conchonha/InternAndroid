package com.example.taskdeha.ui.call

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.taskdeha.MainActivity
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.data.api.ApiInterface
import com.example.taskdeha.databinding.FragmentCallBinding
import com.example.taskdeha.databinding.LoadingBinding
import com.example.taskdeha.ui.adapter.ItemAdapter
import com.example.taskdeha.utils.ItemSpacingDecoration

class FragmentCall : BaseFragment<FragmentCallBinding,CallViewModel>() {
    override val viewModel: CallViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_call

    private lateinit var adapter: ItemAdapter


    //    private val adapter by lazy { ItemAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemAdapter()
        initViewModel()
        viewModel.getData()
        val horizontalSpacing =
            resources.getDimensionPixelSize(R.dimen._14dp)
        val verticalSpacing = resources.getDimensionPixelSize(R.dimen._14dp)
        with(binding) {
            recyclerview.adapter = adapter
            recyclerview.addItemDecoration(
                ItemSpacingDecoration(
                    horizontalSpacing,
                    verticalSpacing
                )
            )
        }

        requireActivity() as MainActivity
    }

    private fun initViewModel() {
        viewModel.metaData.observe(viewLifecycleOwner) {
            adapter.updateData(it.suggestedSearches)
        }
        viewModel.message.observe(viewLifecycleOwner) {
            AlertDialog.Builder(context)
                .setCancelable(true)
                .setMessage(it.toString())
                .setTitle(null)
                .setPositiveButton("Close") { dialog, _ ->
                    dialog.cancel()
                    requireActivity().finish()
                }
                .show()
        }
    }
}