package com.example.android.thescores.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.thescores.model.FootballCompetition
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballDao {

    @Insert
    fun addAllCompetitions(competitionsItem: List<FootballCompetition>)

    @Query("SELECT * FROM competition ORDER BY country")
    fun getAllCompetitions() : Flow<List<FootballCompetition>>

    @Query("DELETE FROM competition")
    fun clearDb()
}