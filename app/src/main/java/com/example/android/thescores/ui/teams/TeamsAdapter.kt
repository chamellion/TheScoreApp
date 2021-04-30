package com.example.android.thescores.ui.teams

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.thescores.R
import com.example.android.thescores.databinding.ItemTeamBinding
import com.example.android.thescores.model.TeamsItem
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import timber.log.Timber

class TeamsAdapter :
    ListAdapter<TeamsItem, TeamsAdapter.TeamsViewHolder>(TeamsDiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        return TeamsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class TeamsViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(teamItem: TeamsItem) {
            bindImageToView(binding.teamImage, teamItem)
        }

        private fun bindImageToView(imageView: ImageView, teamItem: TeamsItem) {
            Timber.d("Image link is ${teamItem.crestUrl}")
            if (teamItem.crestUrl != null){
                GlideToVectorYou
                    .init()
                    .with(imageView.context)
                    .setPlaceHolder(R.drawable.loading_animation, R.drawable.ic_broken_image)
                    .load(Uri.parse(teamItem.crestUrl), imageView)
            }
        }

        companion object {
            fun from(parent: ViewGroup): TeamsViewHolder {
                return TeamsViewHolder(
                    ItemTeamBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

}

class TeamsDiffUtils : DiffUtil.ItemCallback<TeamsItem>() {
    override fun areItemsTheSame(oldItem: TeamsItem, newItem: TeamsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TeamsItem, newItem: TeamsItem): Boolean {
        return oldItem == newItem
    }

}