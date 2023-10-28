package com.lbettersuraiukrae.gamesexplorer.screens.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lbettersuraiukrae.gamesexplorer.R
import com.lbettersuraiukrae.gamesexplorer.databinding.FragmentGameDetailBinding
import com.lbettersuraiukrae.gamesexplorer.screens.viewmodel.ApplicationViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailFragment : Fragment() {
    private val binding by lazy { FragmentGameDetailBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<ApplicationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val game = viewModel.gameDetail.value


        Picasso.get().load(game?.thumbnail).placeholder(R.drawable.app_placeholder).into(binding.imageView)
        binding.tvTitle.text = game?.title.toString()
        binding.tvCreator.text = game?.publisher.toString()
        binding.tvDescription.text = game?.short_description.toString()
        binding.tvData.text = game?.release_date.toString()
        binding.tvGenre.text = game?.genre.toString()

        binding.materialToolbar2.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}