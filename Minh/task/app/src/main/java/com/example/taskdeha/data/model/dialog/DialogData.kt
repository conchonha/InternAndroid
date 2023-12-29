package com.example.taskdeha.data.model.dialog

data class DialogData(
    val title: String = "",
    val message: String = "",
    val lblOke: String = "",
    val lblCancel: String = "",
    val isShow: Boolean = true,
    val type: DialogType = DialogType.YES_NO
)


