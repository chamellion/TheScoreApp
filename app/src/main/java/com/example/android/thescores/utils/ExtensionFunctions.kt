package com.example.android.thescores.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import com.example.android.thescores.model.CompetitionResponse
import com.example.android.thescores.model.FootballCompetition

fun CompetitionResponse.extractCompetitionList() : List<FootballCompetition> {
    return this.competitions.map { competitionsItem ->
        FootballCompetition(id = competitionsItem.id,
            leagueName = competitionsItem.name,
            startDate = competitionsItem.currentSeason?.startDate ?: "No Start Date",
            country = competitionsItem.area?.name ?: "No data")
    }
}

fun isOnline(context: Context): Boolean {
    val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    } else {
        val info = connectivityManager.activeNetworkInfo ?: return false
        return info.isConnected
    }
}