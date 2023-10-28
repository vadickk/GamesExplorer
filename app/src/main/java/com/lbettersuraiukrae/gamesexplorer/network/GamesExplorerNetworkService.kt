package com.lbettersuraiukrae.gamesexplorer.network

import com.lbettersuraiukrae.gamesexplorer.network.entities.Game
import retrofit2.http.GET

interface GamesExplorerNetworkService {

    @GET("games")
    suspend fun getAllGames(): List<Game>

    companion object {
        const val BASE_URL = "https://www.freetogame.com/api/"
    }
}