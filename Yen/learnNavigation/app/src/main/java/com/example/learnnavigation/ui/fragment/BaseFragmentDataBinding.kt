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
import com.example.learnnavigation.ui.IInternetChange
import com.example.learnnavigation.ui.activity.MainActivity
import com.example.learnnavigation.utils.DialogUtils
import com.example.learnnavigation.ui.viewmodel.BaseViewModel

abstract class BaseFragmentDataBinding<T :ViewDataBinding,VM: BaseViewModel> :
    Fragment(), IInternetChange {

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

    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).addInternetChange(this)
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as MainActivity).removeInternetChange(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.message.observe(viewLifecycleOwner) {message ->
            DialogUtils.showErrorDialog(requireActivity(), message)
        }
    }

}

