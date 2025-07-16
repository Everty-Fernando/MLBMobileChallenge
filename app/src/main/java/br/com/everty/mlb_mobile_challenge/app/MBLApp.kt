package br.com.everty.mlb_mobile_challenge.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MBLApp: Application() {

    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidContext(this@MBLApp)
        }
    }
}