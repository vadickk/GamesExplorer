package com.lbettersuraiukrae.gamesexplorer.di

import com.lbettersuraiukrae.gamesexplorer.navigation.GamesExplorerNavigationRepository
import com.lbettersuraiukrae.gamesexplorer.network.GamesExplorerNetworkService
import com.lbettersuraiukrae.gamesexplorer.screens.viewmodel.ApplicationViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

val GamesExplorerModule = module {
    single<GamesExplorerNetworkService> {
        val okHttpClient = OkHttpClient.Builder()
            .writeTimeout(Duration.ofMillis(3600 * 24))
            .build()

        Retrofit.Builder()
            .baseUrl(GamesExplorerNetworkService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GamesExplorerNetworkService::class.java)
    }

    single<GamesExplorerNavigationRepository> {
        GamesExplorerNavigationRepository.Base()
    }

    single {
        ApplicationViewModel(get(), get())
    }
}