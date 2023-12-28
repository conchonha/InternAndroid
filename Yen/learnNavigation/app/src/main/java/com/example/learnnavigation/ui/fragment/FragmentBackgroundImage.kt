package com.example.learnnavigation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.learnnavigation.R
import com.example.learnnavigation.ui.adapter.BackgroundImageAdapter
import com.example.learnnavigation.databinding.FragmentBackgroundImageBinding
import com.example.learnnavigation.ui.viewmodel.BackgroundImageViewModel
import com.example.learnnavigation.utils.Const.HORIZONTAL_SPACE
import com.example.learnnavigation.utils.Const.VERTICAL_SPACE
import com.example.learnnavigation.utils.ItemSpacingDecoration
class FragmentBackgroundImage : BaseFragmentDataBinding<FragmentBackgroundImageBinding, BackgroundImageViewModel>() {

    override val layoutId: Int = R.layout.fragment_background_image

    override val vm: BackgroundImageViewModel by viewModels()
    private val adapter by lazy { BackgroundImageAdapter() }

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
            vm.suggestedSearches.observe(viewLifecycleOwner) { Demo ->
                adapter.setData(Demo.suggestedSearches)
            }
            vm.fetchDataFromApi()
        }
    }
}
