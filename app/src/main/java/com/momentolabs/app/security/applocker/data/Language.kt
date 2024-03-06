package com.momentolabs.app.security.applocker.data

import com.momentolabs.app.security.applocker.R

data class Language(
    val type: LanguageType,
    val content: String,
    val iconSource: Int,
    val languageCode: String,
    var isChecked: Boolean = false
)

val listLanguage = listOf(
    Language(
        type = LanguageType.English,
        content = "English",
        languageCode = "en",
        iconSource = R.drawable.ic_language_english
    ),
    Language(
        type = LanguageType.Hindi,
        content = "हिंदी",
        languageCode = "hi",
        iconSource = R.drawable.ic_language_hindi
    ),
    Language(
        type = LanguageType.Spanish,
        content = "Española",
        languageCode = "es",
        iconSource = R.drawable.ic_language_spanish
    ),
    Language(
        type = LanguageType.Russian,
        content = "Русский",
        languageCode = "en",
        iconSource = R.drawable.ic_language_russian
    ),
    Language(
        type = LanguageType.French,
        content = "Français",
        languageCode = "en",
        iconSource = R.drawable.ic_language_french
    ),
    Language(
        type = LanguageType.Korean,
        content = "한국인",
        languageCode = "en",
        iconSource = R.drawable.ic_language_korean
    )
)


enum class LanguageType {
    English, Hindi, Spanish, Russian, French, Korean
}
