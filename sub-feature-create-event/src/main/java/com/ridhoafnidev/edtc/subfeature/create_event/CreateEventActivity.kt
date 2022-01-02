package com.ridhoafnidev.edtc.subfeature.create_event

import androidx.navigation.findNavController
import com.ridhoafnidev.edtc.core_resource.components.base.BaseActivity
import com.ridhoafnidev.edtc.core_util.setSystemBarColor
import com.ridhoafnidev.edtc.subfeature.create_event.databinding.ActivityCreateEventBinding

class CreateEventActivity : BaseActivity<ActivityCreateEventBinding>(ActivityCreateEventBinding::inflate) {

    private val navController by lazy { findNavController(R.id.event_navigation) }

    override fun initView() {
        setSystemBarColor(R.color.colorBackgroundSecondary)
        initToolbar(back = true, primary = true)
        setPageName(getString(R.string.create_event))
    }

    override fun initListener() {
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

}