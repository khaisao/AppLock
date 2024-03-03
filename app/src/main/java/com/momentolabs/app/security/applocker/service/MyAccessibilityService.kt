package com.momentolabs.app.security.applocker.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.momentolabs.app.security.applocker.PackageNameSendByEventBus
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject


class MyAccessibilityService @Inject constructor() : AccessibilityService() {

    companion object {

    }

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
//        get()
//
//        foregroundFlowable?.subscribe(
//            { packageName ->
//                Log.d("asgagwawg", "Received: $packageName")
//                // Xử lý giá trị packageName nhận được
//            },
//            { error -> Log.e("asgagwawg", "Error: ${error.message}") },
//            { Log.d("asgagwawg", "Completed") }
//        )
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

//    fun get(): Flowable<String> {
//        foregroundFlowable = Flowable.create({ emitter: FlowableEmitter<String> ->
//            flowableEmitter = emitter
//        }, BackpressureStrategy.BUFFER)
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.io())
//        return foregroundFlowable!!
//    }
}
