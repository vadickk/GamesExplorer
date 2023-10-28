package com.lbettersuraiukrae.gamesexplorer.screens.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.lbettersuraiukrae.gamesexplorer.navigation.GamesExplorerNavigationRepository
import com.lbettersuraiukrae.gamesexplorer.network.GamesExplorerNetworkService
import com.lbettersuraiukrae.gamesexplorer.network.entities.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApplicationViewModel(
    private val gamesExplorerNetworkService: GamesExplorerNetworkService,
    private val gamesExplorerNavigationRepository: GamesExplorerNavigationRepository
) : ViewModel(), GamesExplorerNavigationRepository {

    val games = MutableLiveData(listOf<Game>())
    val gameDetail = MutableLiveData<Game>()

    fun getAllGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val games = gamesExplorerNetworkService.getAllGames()
            this@ApplicationViewModel.games.postValue(games)
        }
    }

    override fun navigateToGameDetailsFragment(navController: NavController) {
        gamesExplorerNavigationRepository.navigateToGameDetailsFragment(navController)
    }
}