package com.ridhoafnidev.edtc.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridhoafnidev.edtc.core_data.domain.ListEvents
import com.ridhoafnidev.edtc.core_domain.usecase.EventUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val eventUseCase: EventUseCase
) : ViewModel() {

    private val _newEvent = MutableLiveData<ListEvents>()
    val newEvent: LiveData<ListEvents> = _newEvent

    fun getEvent() {
        viewModelScope.launch {
            eventUseCase.getEvents()
                .collect {
                    _newEvent.value = it
                }
        }
    }
}