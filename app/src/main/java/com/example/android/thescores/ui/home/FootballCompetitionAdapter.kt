package com.example.android.thescores.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.thescores.databinding.ItemFootballCompetitionBinding
import com.example.android.thescores.model.FootballCompetition

class FootballCompetitionAdapter(private val clickListener: FootballCompetitionClickListener) :
    ListAdapter<FootballCompetition,
            FootballCompetitionAdapter.FootballCompetitionViewHolder>(FootballCompetitionDiffUtil()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballCompetitionViewHolder {
        return FootballCompetitionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FootballCompetitionViewHolder, position: Int) {
        val footballCompetition = getItem(position)
        holder.bind(footballCompetition)
        holder.itemView.setOnClickListener {
            clickListener.onFootballClickListener(footballCompetition)
        }
    }


    class FootballCompetitionViewHolder(private val binding : ItemFootballCompetitionBinding)
        : RecyclerView.ViewHolder(binding.root){

            fun bind(footballCompetition: FootballCompetition){
                binding.footballCompetition = footballCompetition
            }

        companion object{
            fun from(parent: ViewGroup) : FootballCompetitionViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemFootballCompetitionBinding.inflate(inflater, parent, false)
                return FootballCompetitionViewHolder(view)
            }
        }
        }
}

class FootballCompetitionDiffUtil : DiffUtil.ItemCallback<FootballCompetition>(){
    override fun areItemsTheSame(oldItem: FootballCompetition, newItem: FootballCompetition): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FootballCompetition, newItem: FootballCompetition): Boolean {
        return oldItem == newItem
    }
}

class FootballCompetitionClickListener(val listener: (competitionID : Int)-> Unit){
    fun onFootballClickListener(footballCompetition: FootballCompetition) = listener(footballCompetition.id)
}