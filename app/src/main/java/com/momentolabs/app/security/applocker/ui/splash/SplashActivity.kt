package com.momentolabs.app.security.applocker.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.databinding.ActivitySplashBinding
import com.momentolabs.app.security.applocker.ui.BaseActivity
import com.momentolabs.app.security.applocker.ui.main.MainActivity
import com.momentolabs.app.security.applocker.ui.main.MainViewModel
import com.momentolabs.app.security.applocker.util.AdsManager

class SplashActivity : BaseActivity<MainViewModel>() {

    private lateinit var binding: ActivitySplashBinding

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        AdsManager.showAdBanner(this, "", findViewById(R.id.banner), findViewById(R.id.line))
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
    }
}
