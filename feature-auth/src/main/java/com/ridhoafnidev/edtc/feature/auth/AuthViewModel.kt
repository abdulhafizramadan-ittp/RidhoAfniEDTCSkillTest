package com.ridhoafnidev.edtc.feature.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridhoafnidev.edtc.core_domain.model.Auth
import com.ridhoafnidev.edtc.core_domain.usecase.AuthUseCase
import com.ridhoafnidev.edtc.core_util.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    var emailOrPhoneNumber = ""
    var password = ""

    var _isLogin = MutableLiveData<Resource<Auth>>()
    var isLogin: LiveData<Resource<Auth>> = _isLogin

    fun login(){
        val auth = Auth(
            emailOrPhoneNumber = emailOrPhoneNumber,
            password = password
        )
        viewModelScope.launch {
            authUseCase.login(auth).collect {
                _isLogin.value = it
            }
        }
    }

}