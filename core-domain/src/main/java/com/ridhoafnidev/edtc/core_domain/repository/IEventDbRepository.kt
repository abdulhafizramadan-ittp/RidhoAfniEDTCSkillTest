package com.ridhoafnidev.edtc.core_domain.repository

import com.ridhoafnidev.edtc.core_data.domain.Event
import com.ridhoafnidev.edtc.core_data.domain.ListEvents
import kotlinx.coroutines.flow.Flow

interface IEventDbRepository {
    fun getEvents(): Flow<ListEvents>
    suspend fun insertEvent(event: Event)
}