package com.example.android.thescores.repository

import com.example.android.thescores.model.TeamResponse
import com.example.android.thescores.networkapi.FootballNetworkService
import javax.inject.Inject

class TeamsRepository @Inject constructor(private val footballNetworkService: FootballNetworkService) {


    suspend fun getTeamsFromNetwork(teamId: Int): TeamResponse {
        val teamResponse = footballNetworkService.getTeamImagesAsync(teamId)
        return teamResponse.await()
    }
}