package com.momentolabs.app.security.applocker.ui.security.analytics

import android.content.Context
import android.os.Bundle

object SecurityFragmentAnalytics {

    fun onAppLocked(context: Context) {
    }

    fun onAppUnlocked(context: Context) {
    }

    fun onBrowserClicked(context: Context) {
    }

    fun onBackgroundClicked(context: Context) {
    }

    fun onCallBlockerClicked(context: Context) {
    }

    fun onVaultClicked(context: Context) {
    }

    private const val EVENT_NAME_APP_LOCKED = "app_item_locked"
    private const val EVENT_NAME_APP_UNLOCKED = "app_item_unlocked"

    private const val EVENT_NAME_BROWSER = "browser_clicked"
    private const val EVENT_NAME_BACKGROUND = "background_clicked"
    private const val EVENT_NAME_VAULT = "vault_clicked"
    private const val EVENT_NAME_CALL_BLOCKER = "call_blocker_clicked"

}
