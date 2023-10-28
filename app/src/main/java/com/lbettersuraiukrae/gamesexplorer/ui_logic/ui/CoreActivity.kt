package com.lbettersuraiukrae.gamesexplorer.ui_logic.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lbettersuraiukrae.gamesexplorer.databinding.ActivityMainBinding

class CoreActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}