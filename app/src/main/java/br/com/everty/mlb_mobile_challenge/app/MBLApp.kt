package br.com.everty.mlb_mobile_challenge.app

import android.app.Application
import br.com.everty.product.di.injectProductModules
import br.com.everty.shared.network.di.injectNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MBLApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@MBLApp)
        }
        initFeatureModules()
        initSharedModules()
    }

    private fun initFeatureModules() {
        injectProductModules()
    }

    private fun initSharedModules() {
        injectNetworkModule()
    }
}