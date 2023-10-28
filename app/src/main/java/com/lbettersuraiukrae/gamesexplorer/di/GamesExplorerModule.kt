package com.lbettersuraiukrae.gamesexplorer.di

import com.lbettersuraiukrae.gamesexplorer.internet.GamesExplorerInternetApi
import com.lbettersuraiukrae.gamesexplorer.navigation.NavRepoGamesExplorer
import com.lbettersuraiukrae.gamesexplorer.viewmodel.CoreViewModel
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

val MainAppModule = module {
    single<GamesExplorerInternetApi> {
        val okHttpClient = OkHttpClient.Builder()
            .writeTimeout(Duration.ofMillis(3600 * 24))
            .build()

        Retrofit.Builder()
            .baseUrl(GamesExplorerInternetApi.CORE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GamesExplorerInternetApi::class.java)
    }

    single<NavRepoGamesExplorer> {
        NavRepoGamesExplorer()
    }

    single {
        CoreViewModel(get(), get())
    }
}