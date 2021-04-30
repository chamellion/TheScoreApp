package com.example.android.thescores.ui.teamDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.thescores.databinding.ItemPlayerBinding
import com.example.android.thescores.model.TeamPlayers
import com.example.android.thescores.utils.getInitials
const val DELIMITER = "T"

class TeamPlayerAdapter :
        ListAdapter<TeamPlayers, TeamPlayerAdapter.TeamPlayerViewHolder>(TeamPlayerDiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamPlayerViewHolder {
        return TeamPlayerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TeamPlayerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class TeamPlayerViewHolder(private val binding: ItemPlayerBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(teamPlayers: TeamPlayers) {
            binding.teamPlayer = teamPlayers
            binding.intials.text = getInitials(teamPlayers.playerName)
            binding.time.text = truncateInvalidDate(teamPlayers.playerDOB)
        }

        private fun truncateInvalidDate(date : String) : String{
            val stringArray = date.split(DELIMITER)
            return stringArray[0]
        }

        companion object{
            fun from(parent: ViewGroup): TeamPlayerViewHolder{
                return TeamPlayerViewHolder(ItemPlayerBinding
                        .inflate(LayoutInflater.from(parent.context),parent, false))
            }
        }
    }

}

class TeamPlayerDiffUtils : DiffUtil.ItemCallback<TeamPlayers>(){
    override fun areItemsTheSame(oldItem: TeamPlayers, newItem: TeamPlayers): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TeamPlayers, newItem: TeamPlayers): Boolean {
        return oldItem == newItem
    }

}