package com.example.learnnavigation.ui.fragment.introduce

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.FragmentIntroductionsBinding
import com.example.learnnavigation.ui.adapter.IntroduceViewPageAdapter
import com.example.learnnavigation.ui.fragment.BaseFragmentDataBinding
import com.example.learnnavigation.ui.viewmodel.IntroduceViewModel
import com.example.learnnavigation.utils.Const.INTRODUCE
class FragmentIntroduction: BaseFragmentDataBinding<FragmentIntroductionsBinding, IntroduceViewModel>() {
    override val layoutId: Int =R.layout.fragment_introductions
    override val vm: IntroduceViewModel by viewModels()

    private val viewPage2 by lazy {binding.vpIntroduce}
    private val adapter by lazy {IntroduceViewPageAdapter()}

    private val items = INTRODUCE

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.updateItems(items)

       with(binding) {
            viewPage2.adapter = adapter
           circleIndicator.setViewPager(viewPage2)
            tvSkip.setOnClickListener {
                //vm.onSkipClicked()
                findNavController().navigate(R.id.action_fragmentIntroduction_to_fragmentHost)

            }
           btContinue.setOnClickListener {
                val itemCount = adapter.itemCount
                var currentItem = viewPage2.currentItem
              // vm.onContinueClicked(currentItem, itemCount)
               if(currentItem == itemCount - 1 ){
                   findNavController().navigate(R.id.action_fragmentIntroduction_to_fragmentHost)
               }else{
                   currentItem += 1
               }
           }

       }
    }
}