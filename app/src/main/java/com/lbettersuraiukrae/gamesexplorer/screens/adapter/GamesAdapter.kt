package com.lbettersuraiukrae.gamesexplorer.screens.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lbettersuraiukrae.gamesexplorer.R
import com.lbettersuraiukrae.gamesexplorer.databinding.ItemGameBinding
import com.lbettersuraiukrae.gamesexplorer.network.entities.Game
import com.squareup.picasso.Picasso

class GamesAdapter(
    private val onCountryClickListener: OnCountryClickListener
) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {
    private val games = mutableListOf<Game>()

    inner class GamesViewHolder(private val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            Picasso.get().load(game.thumbnail).placeholder(R.drawable.app_placeholder).into(binding.ivGameAvatar)
            binding.tvCreator.text = game.publisher
            binding.tvTitle.text = game.title
            binding.tvDescription.text = game.release_date
            binding.gameContainer.setOnClickListener {
                onCountryClickListener.onClick(game)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount() = games.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewGames(newGames: List<Game>) {
        games.clear()
        games.addAll(newGames)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun shuffleGames() {
        games.shuffle()
        notifyDataSetChanged()
    }
}

fun interface OnCountryClickListener {
    fun onClick(game: Game)
}