package com.ridhoafnidev.edtc.core_domain.usecase

import com.ridhoafnidev.edtc.core_domain.model.Auth
import com.ridhoafnidev.edtc.core_util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthUseCase {
    fun login(auth: Auth) : Flow<Resource<Auth>>
}