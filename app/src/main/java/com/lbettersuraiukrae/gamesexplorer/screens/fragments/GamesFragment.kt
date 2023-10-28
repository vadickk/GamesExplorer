package com.lbettersuraiukrae.gamesexplorer.screens.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lbettersuraiukrae.gamesexplorer.R
import com.lbettersuraiukrae.gamesexplorer.databinding.FragmentGamesBinding
import com.lbettersuraiukrae.gamesexplorer.screens.adapter.GamesAdapter
import com.lbettersuraiukrae.gamesexplorer.screens.viewmodel.ApplicationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesFragment : Fragment() {
    private val binding by lazy { FragmentGamesBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<ApplicationViewModel>()
    private val adapter = GamesAdapter {
        viewModel.gameDetail.value = it
        viewModel.navigateToGameDetailsFragment(findNavController())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvGames.adapter = adapter

        viewModel.games.observe(viewLifecycleOwner) {
            adapter.setNewGames(it)
        }

        viewModel.getAllGames()

        binding.materialToolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.itemShuffleGames) {
                adapter.shuffleGames()
            }
            true
        }
    }
}