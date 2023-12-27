package com.example.learnnavigation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.learnnavigation.R
import com.example.learnnavigation.ui.adapter.AnimImageAdapter
import com.example.learnnavigation.databinding.FragmentRingBinding
import com.example.learnnavigation.ui.viewmodel.RingViewModel
import com.example.learnnavigation.utils.Const.HORIZONTAL_SPACE
import com.example.learnnavigation.utils.Const.VERTICAL_SPACE
import com.example.learnnavigation.utils.ItemSpacingDecoration

class FragmentRing : BaseFragmentDataBinding<FragmentRingBinding,RingViewModel>() {
    override val vm: RingViewModel   by viewModels()

    override val layoutId: Int = R.layout.fragment_ring

    private val adapter by lazy { AnimImageAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recycleViewChartFragment.adapter = adapter
            recycleViewChartFragment. addItemDecoration(
                ItemSpacingDecoration(
                    VERTICAL_SPACE,
                    HORIZONTAL_SPACE
                )
            )
            vm.drinks.observe(viewLifecycleOwner) { drinks ->
                adapter.setData(drinks)
            }
            vm.fetchDataFromApi(requireContext())
        }
    }
}

