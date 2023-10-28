package com.lbettersuraiukrae.gamesexplorer.application

import android.app.Application
import com.lbettersuraiukrae.gamesexplorer.di.GamesExplorerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GamesExplorerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(GamesExplorerModule)
        }
    }
}