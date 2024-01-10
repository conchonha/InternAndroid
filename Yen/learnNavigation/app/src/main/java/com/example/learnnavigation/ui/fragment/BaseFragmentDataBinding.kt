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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.learnnavigation.ui.IInternetChange
import com.example.learnnavigation.ui.activity.MainActivity
import com.example.learnnavigation.ui.dialog.DialogYesNoOption
import com.example.learnnavigation.ui.viewmodel.BaseViewModel
import com.example.learnnavigation.ui.viewmodel.IActionMainActivity
import com.example.learnnavigation.utils.EventSender
import kotlinx.coroutines.launch

abstract class BaseFragmentDataBinding<T :ViewDataBinding,VM: BaseViewModel> :
    Fragment(), IInternetChange {

   private val dialogYesNo by lazy { DialogYesNoOption() }
    protected abstract val vm: VM
      lateinit var binding: T
    private var isState = false

     protected val mainActivity: MainActivity?
          get() = (requireActivity() as? MainActivity)

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       vm.iActivityAction = mainActivity
        vm.onInit(arg = arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ()")
        if (::binding.isLateinit){
            binding = DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply {
                lifecycleOwner = viewLifecycleOwner
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (!vm.isResume){
            vm.isResume = true
        }
        onFragmentResume(vm.isResume)
    }


    open fun onFragmentResume(isResume: Boolean){

    }

    override fun onStart() {
        super.onStart()
        mainActivity?.addInternetChange(this)
    }

    override fun onStop() {
        super.onStop()
        mainActivity?.removeInternetChange(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.message.observe(viewLifecycleOwner) {message ->
          //  DialogUtils.showErrorDialog(requireActivity(), message)
        }
        lifecycleScope.launch {
            vm.event.collect{
                when(it){
                    is EventSender.Navigation -> navigation(it.id, it.bundle)
                    else -> {}
                }
            }
        }
    }
    private fun navigation(id: Int, bundle: Bundle?) {
        findNavController().navigate(id,bundle)
    }
    override fun onInternetChange(isNetWork: Boolean) {
        if (!isNetWork) {
            if (!dialogYesNo.isShow){
                dialogYesNo.dialogData.isLoading = false
                dialogYesNo.show(childFragmentManager)
                Log.d("Tesddt", "is network")
            }

        } else {
            dialogYesNo.dialogData.isLoading = true
            if (dialogYesNo.isVisible){
                dialogYesNo.updateUi()
            }
        }
    }
}

