package com.example.learnnavigation.ui.dialog.model

data class DialogData(
    var title: String = "",
    var message: String = "",
    var lblOke: String = "",
    var lblCancel: String = "",
    var isLoading: Boolean = true,
    var type: DialogType = DialogType.YES_NO
)
