package com.momentolabs.app.security.applocker.ui.language

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.data.listLanguage
import com.momentolabs.app.security.applocker.databinding.ActivityLanguageBinding
import com.momentolabs.app.security.applocker.ui.BaseActivity
import com.momentolabs.app.security.applocker.ui.main.MainActivity
import com.momentolabs.app.security.applocker.util.extensions.setLanguage

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

        val languageCode = viewModel.getLanguageAndSetLanguage()
        listLanguage.find { it.languageCode == languageCode }?.isChecked = true
        adapter.setLanguageList(listLanguage)
        binding.ivChooseLanguage.setOnClickListener {
            for (item in listLanguage) {
                if (item.isChecked) {
                    viewModel.setLanguage(item.languageCode)
                    setLanguage(item.languageCode)
                    // Restart the current activity
                    val restartIntent = Intent(this, MainActivity::class.java)
                    restartIntent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(restartIntent)
                }
            }
        }

    }

    private fun resetDataAdapter() {
        adapter.setLanguageList(listLanguage)
    }

}