package com.lbettersuraiukrae.gamesexplorer.navigation

import androidx.navigation.NavController
import com.lbettersuraiukrae.gamesexplorer.R

class NavRepoGamesExplorer {
    fun goToDetails(navController: NavController) {
        navController.navigate(R.id.actionFromGamesFragmentToDetailsGameFragment)
    }
}