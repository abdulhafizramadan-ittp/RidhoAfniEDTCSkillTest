package com.ridhoafnidev.edtc

import android.app.Application
import com.ridhoafnidev.edtc.core_data.dataModule
import com.ridhoafnidev.edtc.core_data.di.domainModule
import com.ridhoafnidev.edtc.feature.auth.authModule
import com.ridhoafnidev.edtc.feature.home.homeModule
import io.armcha.debugBanner.Banner
import io.armcha.debugBanner.BuildConfig
import io.armcha.debugBanner.DebugBanner
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        when (BuildConfig.BUILD_TYPE) {
            "debug" -> "DEV"
            else -> ""
        }.let {
            val banner = Banner(bannerText = it, bannerColorRes = R.color.colorEnvBanner)
            DebugBanner.init(this, banner)
        }


        when(BuildConfig.BUILD_TYPE) {
            "debug" -> Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    authModule,
                    homeModule,
                    domainModule
                )
            )
        }
    }
}