package com.momentolabs.app.security.applocker.service

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.content.ContextCompat


object ServiceStarter {

    fun startService(context: Context) {
        val serviceIntent = Intent(context, AppLockerService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ContextCompat.startForegroundService(context, serviceIntent)
            context.startForegroundService(serviceIntent)
        } else {
            context.startService(serviceIntent)
        }
    }
}