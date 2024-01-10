package com.example.learnnavigation.utils

import android.os.Bundle

sealed class EventSender {
    data class Navigation(val id: Int, val bundle: Bundle?) : EventSender()
    data class ShowToast(val message: String) : EventSender()

    data class ShowDialogYesNo(val message: String) : EventSender()
}