package com.example.taskdeha.ui.call

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.taskdeha.MainActivity
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.data.model.dialog.DialogData
import com.example.taskdeha.databinding.FragmentCallBinding
import com.example.taskdeha.ui.adapter.ItemAdapter
import com.example.taskdeha.ui.gif.GifViewModel
import com.example.taskdeha.utils.CustomDialog
import com.example.taskdeha.utils.ItemSpacingDecoration

class FragmentCall : BaseFragment<FragmentCallBinding, CallViewModel>() {
    override val viewModel: CallViewModel by viewModels()
    val viewModelGif: GifViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_call

    private lateinit var adapter: ItemAdapter
    private lateinit var adapter2: ItemAdapter
    val revenueMonth: MutableList<Long> = mutableListOf()
    var dialog=CustomDialog()

    //    private val adapter by lazy { ItemAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemAdapter()
        adapter2 = ItemAdapter()
        initViewModel()
        viewModel.getData()
//        viewModel.getProduct()
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

//            CustomDialog().requestWin
//            recyclerviewDrink.adapter=adapter2
        }
//        lineChart(revenueMonth)
        requireActivity() as MainActivity
    }


    private fun initViewModel() {
        viewModel.metaData.observe(viewLifecycleOwner) { meta ->
            adapter.updateData(meta.suggestedSearches)
            Log.d("TESST", meta.suggestedSearches.toString())
        }
    }
}