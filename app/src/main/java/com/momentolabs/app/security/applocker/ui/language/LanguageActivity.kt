package com.momentolabs.app.security.applocker.ui.language

import android.content.res.Configuration
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.data.listLanguage
import com.momentolabs.app.security.applocker.databinding.ActivityLanguageBinding
import com.momentolabs.app.security.applocker.ui.BaseActivity
import com.momentolabs.app.security.applocker.util.extensions.toast
import java.util.Locale

class LanguageActivity : BaseActivity<LanguageViewModel>() {
    override fun getViewModel(): Class<LanguageViewModel> = LanguageViewModel::class.java

    val adapter = LanguageAdapter(onClickRadioButton = { language ->
        listLanguage.forEach {
            it.isChecked = false
        }
        listLanguage.find { it.type == language.type }?.isChecked = true
        resetDataAdapter()
    })
    private lateinit var binding: ActivityLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_language)
        binding.rvLanguage.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvLanguage.adapter = adapter
        adapter.setLanguageList(listLanguage)
        binding.ivChooseLanguage.setOnClickListener {
            setLocale("ko")
        }

    }

    private fun resetDataAdapter() {
        adapter.setLanguageList(listLanguage)
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val configuration: Configuration = resources.configuration
        configuration.setLocale(locale)
        createConfigurationContext(configuration)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

}