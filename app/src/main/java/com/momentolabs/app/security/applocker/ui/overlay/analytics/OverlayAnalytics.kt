package com.momentolabs.app.security.applocker.ui.overlay.analytics

import android.content.Context
import android.os.Bundle

object OverlayAnalytics {

    fun sendIntrudersPhotoTakenEvent(context: Context) {
    }

    fun sendIntrudersCameraFailedEvent(context: Context) {
    }

    private const val EVENT_NAME_INTRUDERS_CATCHED = "EVENT_NAME_INTRUDERS_CATCHED"
    private const val EVENT_NAME_INTRUDERS_CAMERA_FAILED = "EVENT_NAME_INTRUDERS_CAMERA_FAILED"
}