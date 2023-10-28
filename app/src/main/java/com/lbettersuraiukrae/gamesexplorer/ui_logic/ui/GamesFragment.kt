package com.lbettersuraiukrae.gamesexplorer.ui_logic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lbettersuraiukrae.gamesexplorer.R
import com.lbettersuraiukrae.gamesexplorer.databinding.FragmentGamesBinding
import com.lbettersuraiukrae.gamesexplorer.ui_logic.adapter.GamesRVAdapter
import com.lbettersuraiukrae.gamesexplorer.viewmodel.CoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesFragment : Fragment() {
    private val binding by lazy { FragmentGamesBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<CoreViewModel>()
    private val adapter = GamesRVAdapter {
        viewModel.gameEntityDetail.value = it
        viewModel.navigateToGameDetailsFragment(findNavController())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
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