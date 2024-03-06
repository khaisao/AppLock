package com.momentolabs.app.security.applocker.ui.overlay.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.andrognito.patternlockview.PatternLockView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.databinding.ActivityOverlayValidationBinding
import com.momentolabs.app.security.applocker.ui.BaseActivity
import com.momentolabs.app.security.applocker.ui.intruders.camera.FrontPictureLiveData
import com.momentolabs.app.security.applocker.ui.intruders.camera.FrontPictureState
import com.momentolabs.app.security.applocker.ui.newpattern.SimplePatternListener
import com.momentolabs.app.security.applocker.ui.overlay.analytics.OverlayAnalytics
import com.momentolabs.app.security.applocker.util.extensions.convertToPatternDot
import com.momentolabs.app.security.applocker.util.helper.file.FileManager
import com.vapp.admoblibrary.ads.AdmobUtils
import com.vapp.admoblibrary.ads.admobnative.enumclass.GoogleENative
import com.vapp.admoblibrary.ads.model.NativeHolder
import javax.inject.Inject


class OverlayValidationActivity : BaseActivity<OverlayValidationViewModel>() {

    @Inject
    lateinit var fileManager: FileManager

    private lateinit var frontPictureLiveData: FrontPictureLiveData

    private lateinit var binding: ActivityOverlayValidationBinding

    override fun getViewModel(): Class<OverlayValidationViewModel> =
        OverlayValidationViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_overlay_validation)

        intent.getStringExtra(KEY_PACKAGE_NAME)?.let { updateLaunchingAppIcon(it) }
        var nativeHolder = NativeHolder(
            "ca-app-pub-3940256099942544/2247696110"
        )

        AdmobUtils.loadAndShowNativeAdsWithLayoutAds(
            activity = this,
            nativeHolder = nativeHolder,
            viewGroup = binding.adContainer,
            layout = R.layout.ad_template_medium,
            size = GoogleENative.UNIFIED_MEDIUM,
            adCallback = object : AdmobUtils.NativeAdCallbackNew {
                override fun onAdFail(error: String) {
                    Log.d("asgawgawgawg", "onAdFail: $error")
                }

                override fun onAdPaid(
                    adValue: com.google.android.gms.ads.AdValue?,
                    adUnitAds: String?
                ) {
                }

                override fun onClickAds() {
                }

                override fun onLoadedAndGetNativeAd(ad: com.google.android.gms.ads.nativead.NativeAd?) {
                }

                override fun onNativeAdLoaded() {
                }

            }

        )
        frontPictureLiveData =
            FrontPictureLiveData(application, viewModel.getIntruderPictureImageFile())

        viewModel.getViewStateObservable().observe(this, Observer {
            binding.patternLockView.clearPattern()
            binding.viewState = it
            binding.executePendingBindings()

            if (it.isDrawnCorrect == true || it.fingerPrintResultData?.isSucces() == true) {
                setResult(Activity.RESULT_OK)
                finish()
            }

            if (it.isDrawnCorrect == false || it.fingerPrintResultData?.isNotSucces() == true) {
                YoYo.with(Techniques.Shake)
                    .duration(700)
                    .playOn(binding.textViewPrompt)

                if (it.isIntrudersCatcherMode) {
                    frontPictureLiveData.takePicture()
                }
            }
        })

        viewModel.getBackgroundDrawableLiveData().observe(this, Observer {
            binding.layoutOverlayMain.background = it.getGradiendDrawable(this)
        })

        binding.patternLockView.addPatternLockListener(object : SimplePatternListener() {
            override fun onComplete(pattern: MutableList<PatternLockView.Dot>?) {
                super.onComplete(pattern)
                pattern?.let { viewModel.onPatternDrawn(it.convertToPatternDot()) }
            }
        })

        frontPictureLiveData.observe(this, Observer {
            when (it) {
                is FrontPictureState.Taken -> OverlayAnalytics.sendIntrudersPhotoTakenEvent(this)
                is FrontPictureState.Error -> OverlayAnalytics.sendIntrudersCameraFailedEvent(this)
                is FrontPictureState.Destroyed -> {}
                is FrontPictureState.Started -> {}
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent("android.intent.action.MAIN")
        intent.addCategory("android.intent.category.HOME")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun onResume() {
        super.onResume()
        showBannerAd()
    }

    private fun showBannerAd() {

    }

    private fun updateLaunchingAppIcon(appPackageName: String) {
        try {
            val icon = packageManager.getApplicationIcon(appPackageName)
            binding.avatarLock.setImageDrawable(icon)
        } catch (e: PackageManager.NameNotFoundException) {
            binding.avatarLock.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_round_lock_24px
                )
            )
            e.printStackTrace()
        }
    }

    companion object {

        private const val KEY_PACKAGE_NAME = "KEY_PACKAGE_NAME"

        fun newIntent(context: Context, packageName: String): Intent {
            val intent = Intent(context, OverlayValidationActivity::class.java)
            intent.putExtra(KEY_PACKAGE_NAME, packageName)
            return intent
        }
    }

}