package com.momentolabs.app.security.applocker.ui.language

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.data.listLanguage
import com.momentolabs.app.security.applocker.databinding.ActivityLanguageBinding
import com.momentolabs.app.security.applocker.ui.BaseActivity

class LanguageActivity : BaseActivity<LanguageViewModel>() {
    override fun getViewModel(): Class<LanguageViewModel> = LanguageViewModel::class.java

    val adapter = LanguageAdapter()
    private lateinit var binding: ActivityLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_language)
        binding.rvLanguage.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvLanguage.adapter = adapter
        adapter.setLanguageList(listLanguage)

    }

}