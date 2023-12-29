package com.example.learnnavigation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.learnnavigation.R
import com.example.learnnavigation.ui.adapter.AnimImageAdapter
import com.example.learnnavigation.databinding.FragmentScreenImageBinding
import com.example.learnnavigation.ui.viewmodel.ScreenImageViewModel
import com.example.learnnavigation.utils.Const.HORIZONTAL_SPACE
import com.example.learnnavigation.utils.Const.VERTICAL_SPACE
import com.example.learnnavigation.utils.DialogUtils
import com.example.learnnavigation.utils.ItemSpacingDecoration

class FragmentScreenImage: BaseFragmentDataBinding<FragmentScreenImageBinding, ScreenImageViewModel>() {
    override val layoutId: Int =R.layout.fragment_screen_image

    override val vm: ScreenImageViewModel by viewModels()
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
             vm.drinks.observe(viewLifecycleOwner) { drink ->
                 adapter.setData(drink.drinks)
             }
             vm.fetchDataFromApi()
         }
     }

    override fun onInternetChange(isNetWork: Boolean) {

    }
}