package com.momentolabs.app.security.applocker.ui.background.analytics

import android.content.Context
import android.os.Bundle

object BackgroundAnalytics {

    fun sendBackgroundChangedEvent(context: Context, selectedId: Int) {
    }

    private const val EVENT_NAME_BACKGROUND = "background_changed"
    private const val EVENT_NAME_BACKGROUND_ITEM_ID = "background_changed_id"

}