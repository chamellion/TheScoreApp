package com.example.android.thescores.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competition")
data class FootballCompetition(@PrimaryKey
                               val id : Int,
                               val leagueName : String,
                               val startDate : String,
                               val country : String)

data class TeamPlayers(val id : Int,
                       val playerName : String,
                       val playerPosition : String,
                       val playerCountry : String,
                       val playerDOB : String)

