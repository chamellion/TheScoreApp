package com.example.android.thescores.repository

import com.example.android.thescores.model.TeamPlayerResponse
import com.example.android.thescores.networkapi.FootballNetworkService
import javax.inject.Inject

class TeamPlayerRepository @Inject constructor(private val footballNetworkService: FootballNetworkService) {

    suspend fun loadTeamPlayer(teamId : Int) : TeamPlayerResponse{
        return footballNetworkService.getTeamPlayersAsync(teamId).await()
    }
}