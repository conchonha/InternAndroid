package com.example.learnnavigation.ui.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.learnnavigation.ui.dialog.DialogUtils
import com.example.learnnavigation.ui.viewmodel.BaseViewModel

abstract class BaseFragmentDataBinding<T :ViewDataBinding,VM: BaseViewModel> :
    Fragment() {

    protected abstract val vm: VM
      lateinit var binding: T

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ()")
        binding = DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.message.observe(viewLifecycleOwner){
            DialogUtils.showErrorDialog(requireActivity(),it)
        }
    }
}

