package com.ridhoafnidev.edtc.core_domain.usecase

import com.ridhoafnidev.edtc.core_data.domain.Event
import com.ridhoafnidev.edtc.core_data.domain.ListEvents
import kotlinx.coroutines.flow.Flow

interface EventUseCase {
    fun getEvents() : Flow<ListEvents>
    suspend fun insertEvent(event: Event)
}