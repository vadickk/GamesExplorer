package com.lbettersuraiukrae.gamesexplorer.navigation

import androidx.navigation.NavController
import com.lbettersuraiukrae.gamesexplorer.R

interface GamesExplorerNavigationRepository {

    fun navigateToGameDetailsFragment(navController: NavController)

    class Base : GamesExplorerNavigationRepository {

        override fun navigateToGameDetailsFragment(navController: NavController) {
            navController.navigate(R.id.actionFromGamesFragmentToDetailsGameFragment)
        }
    }
}