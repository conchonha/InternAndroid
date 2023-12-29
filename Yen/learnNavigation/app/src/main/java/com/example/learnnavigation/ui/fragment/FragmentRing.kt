package com.example.learnnavigation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.learnnavigation.R
import com.example.learnnavigation.ui.adapter.AnimImageAdapter
import com.example.learnnavigation.databinding.FragmentRingBinding
import com.example.learnnavigation.ui.dialog.DialogYesNoOption
import com.example.learnnavigation.ui.dialog.model.DialogData
import com.example.learnnavigation.ui.viewmodel.RingViewModel
import com.example.learnnavigation.utils.Const.HORIZONTAL_SPACE
import com.example.learnnavigation.utils.Const.VERTICAL_SPACE
import com.example.learnnavigation.utils.ItemSpacingDecoration
class FragmentRing : BaseFragmentDataBinding<FragmentRingBinding,RingViewModel>() {
//    private val diaogYesNo by lazy { DialogYesNoOption() }
    override val vm: RingViewModel   by viewModels()
    override val layoutId: Int = R.layout.fragment_ring

    private val adapter by lazy { AnimImageAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recycleViewChartFragment.adapter = adapter
            recycleViewChartFragment.addItemDecoration(
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
        if(!isNetWork) {
            val dialogData = DialogData(isLoading = false)
            val dialog = DialogYesNoOption()
            dialog.dialogData = dialogData
            dialog.show(childFragmentManager, "YEN")
            Log.d("Test","is network")
        }
        else{
            val dialogData = DialogData(isLoading = true)
            val dialog1 = DialogYesNoOption()
            dialog1.dialogData = dialogData
            dialog1.show(childFragmentManager, "YEN")
            val dialog = childFragmentManager.findFragmentByTag("YEN") as? DialogYesNoOption
            dialog?.dismiss()
            Toast.makeText(context,"xdf",Toast.LENGTH_SHORT).show()
            Log.d("Test","sffs")
        }
    }
}

