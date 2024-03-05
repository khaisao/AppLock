package com.momentolabs.app.security.applocker.data

import com.momentolabs.app.security.applocker.R

data class Language(
    val type: LanguageType,
    val content: String,
    val iconSource: Int,
    val isChecked: Boolean = false
)

val listLanguage = listOf(
    Language(
        type = LanguageType.English,
        content = "English",
        iconSource = R.drawable.ic_language_english
    ),
    Language(
        type = LanguageType.Hindi,
        content = "हिंदी",
        iconSource = R.drawable.ic_language_hindi
    ),
    Language(
        type = LanguageType.Spanish,
        content = "Española",
        iconSource = R.drawable.ic_language_spanish
    ),
    Language(
        type = LanguageType.Russian,
        content = "Русский",
        iconSource = R.drawable.ic_language_russian
    ),
    Language(
        type = LanguageType.French,
        content = "Français",
        iconSource = R.drawable.ic_language_french
    ),
    Language(
        type = LanguageType.Hindi2,
        content = "हिंदी",
        iconSource = R.drawable.ic_language_hindi2
    ),
    Language(
        type = LanguageType.Korean,
        content = "한국인, iconSource = R.drawable.ic_language_english",
        iconSource = R.drawable.ic_language_korean
    )
)


enum class LanguageType {
    English, Hindi, Spanish, Russian, French, Hindi2, Korean
}
