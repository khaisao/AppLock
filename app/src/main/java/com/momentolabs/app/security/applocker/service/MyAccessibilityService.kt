package com.momentolabs.app.security.applocker.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.momentolabs.app.security.applocker.data.PackageNameSendByEventBus
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject


class MyAccessibilityService @Inject constructor() : AccessibilityService() {

    public override fun onServiceConnected() {
        // Set the type of events that this service wants to listen to. Others
        // aren't passed to this service.
        val info = AccessibilityServiceInfo()
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED or
                AccessibilityEvent.TYPE_VIEW_FOCUSED


        // Set the type of feedback your service provides.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN

        // Default services are invoked only if no package-specific services are
        // present for the type of AccessibilityEvent generated. This service is
        // app-specific, so the flag isn't necessary. For a general-purpose service,
        // consider setting the DEFAULT flag.

        // info.flags = AccessibilityServiceInfo.DEFAULT;
        info.notificationTimeout = 100
        this.serviceInfo = info
        Log.d("asgagwawg", "onServiceConnected: ")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        val packageName = event.packageName.toString()
        EventBus.getDefault().post(PackageNameSendByEventBus(packageName))

        Log.d("asgagwawg", "packageName: $packageName")
    }

    override fun onInterrupt() {
        Log.d("asgagwawg", "onInterrupt: ")
    }
}
