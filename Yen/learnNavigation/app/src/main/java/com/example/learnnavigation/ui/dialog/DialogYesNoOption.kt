package com.example.learnnavigation.ui.dialog

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.DialogYesNoOptionBinding
import com.example.learnnavigation.ui.dialog.model.DialogData

class DialogYesNoOption : BaseDialogFrament<DialogYesNoOptionBinding>() {
    var dialogData = DialogData()
    override val layoutId: Int = R.layout.dialog_yes_no_option
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (dialogData.isLoading) {
           false -> {
               with(binding){
                   tvTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                   tvTitle.text = getString(R.string.TitleIncorrectDialog)
                   ivDialog.setImageResource(R.drawable.ic_cancel)
               }

            }
            true -> {
                with(binding){
                    tvTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
                    tvTitle.text = getString(R.string.TitleCorrectDialog)
                    ivDialog.setImageResource(R.drawable.ic_done)
                }
            }
        }
    }
}





