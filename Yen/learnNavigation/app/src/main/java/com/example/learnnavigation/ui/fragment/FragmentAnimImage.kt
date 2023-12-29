package com.example.learnnavigation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.learnnavigation.R
import com.example.learnnavigation.ui.adapter.AnimImageAdapter
import com.example.learnnavigation.databinding.FragmentAnimationImageBinding
import com.example.learnnavigation.ui.IInternetChange
import com.example.learnnavigation.ui.activity.MainActivity
import com.example.learnnavigation.ui.viewmodel.AnimImageViewModel
import com.example.learnnavigation.utils.Const.HORIZONTAL_SPACE
import com.example.learnnavigation.utils.Const.VERTICAL_SPACE
import com.example.learnnavigation.utils.DialogUtils
import com.example.learnnavigation.utils.ItemSpacingDecoration

//0x1cc
class FragmentAnimImage  : BaseFragmentDataBinding<FragmentAnimationImageBinding, AnimImageViewModel>() {
     override val layoutId: Int = R.layout.fragment_animation_image

    override val vm: AnimImageViewModel by viewModels()
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

            vm.drinks.observe(viewLifecycleOwner) { drink->
                adapter.setData(drink.drinks)
            }
            vm.fetchDataFromApi()
        }
    }
    override fun onInternetChange(isNetWork: Boolean) {

    }
}
