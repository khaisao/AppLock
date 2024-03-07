package com.momentolabs.app.security.applocker.util.extensions

import android.content.Context
import android.content.res.Configuration
import androidx.core.os.ConfigurationCompat.getLocales
import android.os.Build
import android.provider.Settings
import java.util.*


fun Context.getCurrentLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        resources.configuration.locales.get(0)
    } else {
        resources.configuration.locale
    }
}

fun Context.setLanguage(languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val configuration: Configuration = resources.configuration
    configuration.setLocale(locale)
    createConfigurationContext(configuration)
    resources.updateConfiguration(configuration, resources.displayMetrics)
}

fun Context.isCanDrawOverlayPermission(): Boolean {
    return if (Build.VERSION.SDK_INT >= 30) {
        Settings.canDrawOverlays(this)
    } else {
        true
    }
}