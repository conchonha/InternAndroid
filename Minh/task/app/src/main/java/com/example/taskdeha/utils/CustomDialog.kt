package com.example.taskdeha.utils

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseDialogFragment
import com.example.taskdeha.data.model.dialog.DialogData
import com.example.taskdeha.databinding.LayoutDialogBinding

class CustomDialog : BaseDialogFragment<LayoutDialogBinding>() {
    var dialogData = DialogData()
    override val layoutId: Int = R.layout.layout_dialog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMessage.text=dialogData.message
       updateUI()
    }

     fun updateUI() {
        when (dialogData.isSuccess) {
            false -> {
                with(binding) {
                    tvTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                    tvTitle.text = getString(R.string.wrong)
                    ivIcon.setImageResource(R.drawable.ic_wrong)
                }

            }
            else -> {
                with(binding) {
                    tvTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
                    tvTitle.text = getString(R.string.done)
                    ivIcon.setImageResource(R.drawable.ic_done)
                }
            }
        }
    }
}