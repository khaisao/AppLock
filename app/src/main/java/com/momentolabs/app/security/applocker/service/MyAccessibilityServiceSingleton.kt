package com.momentolabs.app.security.applocker.service

object MyAccessibilityServiceSingleton {
    private var instance: MyAccessibilityService? = null

    fun getInstance(): MyAccessibilityService {
        if (instance == null) {
            instance = MyAccessibilityService()
        }
        return instance!!
    }
}