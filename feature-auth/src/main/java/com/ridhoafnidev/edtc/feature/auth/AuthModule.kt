package com.ridhoafnidev.edtc.feature.auth

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Application.authModule
    get() = module {
        viewModel { AuthViewModel(get()) }
    }