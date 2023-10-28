package com.lbettersuraiukrae.gamesexplorer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.lbettersuraiukrae.gamesexplorer.internet.GamesExplorerInternetApi
import com.lbettersuraiukrae.gamesexplorer.internet.data.GameEntity
import com.lbettersuraiukrae.gamesexplorer.navigation.NavRepoGamesExplorer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoreViewModel(
    private val gamesExplorerInternetApi: GamesExplorerInternetApi,
    private val navRepoGamesExplorer: NavRepoGamesExplorer) : ViewModel() {

    fun navigateToGameDetailsFragment(navController: NavController) {
        navRepoGamesExplorer.goToDetails(navController)
    }

    fun getAllGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val games = gamesExplorerInternetApi.getAllGames()
            this@CoreViewModel.games.postValue(games)
        }
    }

    val games = MutableLiveData(listOf<GameEntity>())
    val gameEntityDetail = MutableLiveData<GameEntity>()
}