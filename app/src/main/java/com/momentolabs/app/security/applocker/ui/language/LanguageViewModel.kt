package com.momentolabs.app.security.applocker.ui.language

import com.momentolabs.app.security.applocker.data.AppLockerPreferences
import com.momentolabs.app.security.applocker.ui.RxAwareViewModel
import javax.inject.Inject

class LanguageViewModel @Inject constructor(
    val appLockerPreferences: AppLockerPreferences
) : RxAwareViewModel() {

    fun setLanguage(languageCode: String) {
        appLockerPreferences.setLanguage(languageCode)
    }

    fun getLanguageAndSetLanguage(): String? {
        return appLockerPreferences.getLanguage()
    }

}