package com.ridhoafnidev.edtc.core_data.di

import android.app.Application
import com.ridhoafnidev.edtc.core_domain.usecase.AuthInterator
import com.ridhoafnidev.edtc.core_domain.usecase.AuthUseCase
import com.ridhoafnidev.edtc.core_domain.usecase.EventDbInteractor
import com.ridhoafnidev.edtc.core_domain.usecase.EventUseCase
import org.koin.dsl.module

@Suppress("MaxLineLength")
val Application.domainModule
    get() = module {
        factory<EventUseCase> { EventDbInteractor(get()) }
        factory<AuthUseCase> { AuthInterator( get() ) }
    }