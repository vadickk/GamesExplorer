package com.lbettersuraiukrae.gamesexplorer.app

import android.app.Application
import com.lbettersuraiukrae.gamesexplorer.di.MainAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoreApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(MainAppModule)
        }
    }
}