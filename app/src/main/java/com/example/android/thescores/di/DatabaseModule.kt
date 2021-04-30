package com.example.android.thescores.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.thescores.database.FootballDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideFootballDb(@ApplicationContext appContext : Context): FootballDb{
        return Room.databaseBuilder(appContext,
            FootballDb::class.java,
            "football_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideFootballDao(footballDb: FootballDb) = footballDb.footballDao()

}