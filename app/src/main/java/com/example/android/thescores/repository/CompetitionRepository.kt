package com.example.android.thescores.repository

import androidx.room.withTransaction
import com.example.android.thescores.database.FootballDb
import com.example.android.thescores.model.FootballCompetition
import com.example.android.thescores.networkapi.FootballNetworkService
import com.example.android.thescores.utils.extractCompetitionList
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject


class CompetitionRepository @Inject constructor(private val footballDb: FootballDb,
                                                private val networkService: FootballNetworkService){

    suspend fun syncNetworkWithDatabase(){
        val competitionAsync = networkService.getAllFootballCompetitionAsync()
        try {
            val competitionResponse = competitionAsync.await()
            val competitionList = competitionResponse.extractCompetitionList()
            footballDb.withTransaction {
                footballDb.footballDao().clearDb()
                footballDb.footballDao().addAllCompetitions(competitionList)
            }
        }catch (exception : Exception){
            Timber.d(exception)
        }
    }

    suspend fun loadCompetitionFromNetwork() : List<FootballCompetition>{
        val competitionsResponseAsync = networkService.getAllFootballCompetitionAsync()
        return competitionsResponseAsync.await().extractCompetitionList()
    }

    fun loadCompetitionFromDb() : Flow<List<FootballCompetition>>{
        return footballDb.footballDao().getAllCompetitions()
    }

}