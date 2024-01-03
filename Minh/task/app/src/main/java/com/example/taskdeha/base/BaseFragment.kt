package com.example.taskdeha.base

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
import androidx.viewbinding.ViewBinding
import com.example.taskdeha.IInternetChange
import com.example.taskdeha.MainActivity
import com.example.taskdeha.R
import com.example.taskdeha.data.model.dialog.DialogData
import com.example.taskdeha.utils.CustomDialog
import com.example.taskdeha.utils.DialogUtils


abstract class BaseFragment<T : ViewDataBinding, VM : BaseViewModel> :
    Fragment(), IInternetChange {
    var isInternet: Boolean = true
    private var dialog = CustomDialog()
    lateinit var binding: T

    abstract val viewModel: VM

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.message.observe(viewLifecycleOwner) { message ->
            DialogUtils.showErrorDialog(requireActivity(), message)
        }
    }

    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).addInternetChange(this)
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as MainActivity).removeInternetChange(this)
    }

    override fun onInternetChange(isNetWork: Boolean) {
        if (dialog.isVisible) {
            dialog.dismiss()
            dialog = CustomDialog()
        }
        if (isNetWork) {
            dialog.dialogData = DialogData(isSuccess = true, message = resources.getString(R.string.message_internet_connected))
            DialogUtils.showToast(resources.getString(R.string.message_internet_connected), requireContext())
        } else {
            dialog.dialogData = DialogData(isSuccess = false, message = resources.getString(R.string.message_internet_disconnect))
        }
        dialog.show(childFragmentManager, "")
    }
}