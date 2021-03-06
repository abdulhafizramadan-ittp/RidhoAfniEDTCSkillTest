package com.ridhoafnidev.edtc.feature.home

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Application.homeModule
        get() = module {
            viewModel { HomeViewModel(get()) }
        }