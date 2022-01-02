package com.ridhoafnidev.edtc.feature.auth.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.ridhoafnidev.edtc.core_navigation.ModuleNavigator
import com.ridhoafnidev.edtc.core_resource.components.base.BaseFragment
import com.ridhoafnidev.edtc.feature_auth.R
import com.ridhoafnidev.edtc.feature_auth.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate),
    ModuleNavigator {

    override fun initView() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.loginFragment)
        }, 200)
    }

    override fun initListener() {

    }
}