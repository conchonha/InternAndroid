package com.example.taskdeha.ui.gif

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.databinding.FragmentGifBinding
import com.example.taskdeha.ui.adapter.ItemAdapter
import com.example.taskdeha.ui.call.CallViewModel
import com.example.taskdeha.utils.ItemSpacingDecoration

class FragmentGif : BaseFragment<FragmentGifBinding, GifViewModel>() {
    override val layoutId: Int = R.layout.fragment_gif
    override val viewModel: GifViewModel by viewModels()
    private lateinit var adapter: ItemAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemAdapter()
        initViewModel()
        viewModel.getData()

        val horizontalSpacing = resources.getDimensionPixelSize(R.dimen._14dp)
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