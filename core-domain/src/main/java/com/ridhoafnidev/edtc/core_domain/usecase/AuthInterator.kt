package com.ridhoafnidev.edtc.core_domain.usecase

import com.ridhoafnidev.edtc.core_domain.model.Auth
import com.ridhoafnidev.edtc.core_domain.repository.IAuthRepository
import com.ridhoafnidev.edtc.core_util.Resource
import kotlinx.coroutines.flow.Flow

class AuthInterator(private val authRepository: IAuthRepository) : AuthUseCase {
    override fun login(auth: Auth): Flow<Resource<Auth>> = authRepository.login(auth)
}