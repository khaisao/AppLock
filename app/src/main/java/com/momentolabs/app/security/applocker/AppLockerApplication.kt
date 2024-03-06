package com.momentolabs.app.security.applocker

import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.soloader.SoLoader
import com.facebook.stetho.Stetho
import com.momentolabs.app.security.applocker.di.component.DaggerAppComponent
import com.momentolabs.app.security.applocker.service.ServiceStarter
import com.momentolabs.app.security.applocker.service.worker.WorkerStarter
import com.raqun.beaverlib.Beaver
import com.vapp.admoblibrary.ads.AdmobUtils
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppLockerApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        Beaver.build(this)
        ServiceStarter.startService(this)
        SoLoader.init(this, false)
        WorkerStarter.startServiceCheckerWorker()
        AdmobUtils.initAdmob(context = this, timeout = 10000, isDebug = true, isEnableAds = true)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}