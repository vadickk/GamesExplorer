package com.lbettersuraiukrae.gamesexplorer.ui_logic.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lbettersuraiukrae.gamesexplorer.R
import com.lbettersuraiukrae.gamesexplorer.databinding.ItemGameBinding
import com.lbettersuraiukrae.gamesexplorer.internet.data.GameEntity
import com.lbettersuraiukrae.gamesexplorer.tools.OnCountryClickListener
import com.squareup.picasso.Picasso

class GamesRVAdapter(private val onCountryClickListener: OnCountryClickListener):RecyclerView.Adapter<GamesRVAdapter.GamesViewHolder>() {
    private val gameEntities = mutableListOf<GameEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun shuffleGames() {
        gameEntities.shuffle()
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewGames(newGameEntities : List<GameEntity>) {
        gameEntities.clear()
        gameEntities.addAll(newGameEntities)
        notifyDataSetChanged()
    }

    inner class GamesViewHolder(private val binding: ItemGameBinding) :RecyclerView.ViewHolder(binding.root) {
        fun draw(gameEntity: GameEntity) {
            Picasso.get().load(gameEntity.thumbnail).placeholder(R.drawable.app_placeholder).into(binding.ivGameAvatar)
            binding.tvCreator.text = gameEntity.publisher
            binding.tvTitle.text = gameEntity.title
            binding.tvDescription.text = gameEntity.release_date
            binding.gameContainer.setOnClickListener {
                onCountryClickListener.onClick(gameEntity)
            }
        }
    }

    override fun getItemCount() = gameEntities.size

    override fun onBindViewHolder(holder: GamesViewHolder , position: Int) {
        holder.draw(gameEntities[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):GamesViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

}