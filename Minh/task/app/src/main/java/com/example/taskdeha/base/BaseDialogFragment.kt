package com.example.taskdeha.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment<VB : ViewDataBinding> : DialogFragment() {
    open val width = ViewGroup.LayoutParams.MATCH_PARENT
    open val height = ViewGroup.LayoutParams.WRAP_CONTENT
    open val style: Int? = android.R.style.Theme_Panel

    lateinit var binding: VB

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<VB>(inflater, layoutId, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setDimAmount(0.7f)
        dialog?.setCanceledOnTouchOutside(true)
        dialog?.setCancelable(true)
    }
}