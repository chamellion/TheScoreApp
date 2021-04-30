package com.example.android.thescores.networkapi

import com.example.android.thescores.model.CompetitionResponse
import com.example.android.thescores.model.TeamResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface FootballNetworkService {

    @GET("competitions")
    @Headers("X-Auth-Token: d1d0f4be14054056a03bfbeafced4153")
    fun getAllFootballCompetitionAsync(@Query("plan")tier : String) : Deferred<CompetitionResponse>


    @GET("competitions/{id}/teams")
    @Headers("X-Auth-Token: d1d0f4be14054056a03bfbeafced4153")
    fun getTeamImagesAsync(@Path("id") teamId : Int) : Deferred<TeamResponse>
}