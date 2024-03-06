package com.momentolabs.app.security.applocker.ui.vault.analytics

import android.content.Context
import android.os.Bundle

object VaultAdAnalytics {

    fun bannerAdLoaded(context: Context) {
    }

    fun bannerAdFailed(context: Context) {
    }

    fun bannerAdClicked(context: Context) {
    }

    private const val EVENT_NAME_AD_LOADED = "ads_vault_banner_loaded"
    private const val EVENT_NAME_AD_FAILED = "ads_vault_banner_failed"
    private const val EVENT_NAME_AD_CLICKED = "ads_vault_banner_clicked"
}