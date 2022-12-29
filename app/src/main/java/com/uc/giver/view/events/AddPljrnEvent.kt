package com.uc.giver.view.events

sealed class AddPljrnEvent {
    data class OnPljrnNameChange(val content: String): AddPljrnEvent()
}