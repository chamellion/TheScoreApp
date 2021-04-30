package com.example.android.thescores.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.thescores.model.CompetitionsItem
import com.example.android.thescores.model.FootballCompetition

@Database(entities = [FootballCompetition::class], exportSchema = false, version = 1)
abstract class FootballDb : RoomDatabase() {
    abstract fun footballDao(): FootballDao
}