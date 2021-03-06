package com.ridhoafnidev.edtc.core_util

import android.os.Handler
import android.os.Looper
import android.view.View

fun View.setSingleOnClickListener(callback: () -> Unit) {
    this.setOnClickListener {
        this.isEnabled = false
        Handler(Looper.getMainLooper()).postDelayed({ this.isEnabled = true }, 1000)
        callback.invoke()
    }
}

fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}
