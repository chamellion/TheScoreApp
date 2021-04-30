package com.example.android.thescores.networkapi

import com.example.android.thescores.model.CompetitionResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface FootballNetworkService {

    @GET("competitions")
    @Headers("X-Auth-Token: d1d0f4be14054056a03bfbeafced4153")
    fun getAllFootballCompetitionAsync() : Deferred<CompetitionResponse>
}