package com.lbettersuraiukrae.gamesexplorer.tools

import com.lbettersuraiukrae.gamesexplorer.internet.data.GameEntity

fun interface OnCountryClickListener {
    fun onClick(gameEntity: GameEntity)
}