package com.lbettersuraiukrae.gamesexplorer.internet

import com.lbettersuraiukrae.gamesexplorer.internet.data.GameEntity
import retrofit2.http.GET

interface GamesExplorerInternetApi {

    @GET("games")
    suspend fun getAllGames(): List<GameEntity>

    companion object {
        const val CORE_URL = "https://www.freetogame.com/api/"
    }
}