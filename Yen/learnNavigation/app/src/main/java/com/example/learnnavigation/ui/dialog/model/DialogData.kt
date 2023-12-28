package com.example.learnnavigation.ui.dialog.model

data class DialogData(
    val title: String = "",
    val message: String = "",
    val lblOke: String = "",
    val lblCancel: String = "",
    val isLoading: Boolean = true,
    val type: DialogType = DialogType.YES_NO
)
