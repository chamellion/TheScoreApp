package com.example.android.thescores.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.android.thescores.model.CompetitionResponse
import com.example.android.thescores.model.FootballCompetition
import com.example.android.thescores.model.TeamPlayerResponse
import com.example.android.thescores.model.TeamPlayers

fun CompetitionResponse.extractCompetitionList() : List<FootballCompetition> {
    return this.competitions.map { competitionsItem ->
        FootballCompetition(id = competitionsItem.id,
            leagueName = competitionsItem.name,
            startDate = competitionsItem.currentSeason?.startDate ?: "No Start Date",
            country = competitionsItem.area?.name ?: "No data")
    }
}

fun TeamPlayerResponse.extractTeamPlayer() : List<TeamPlayers>{
    return this.squad.map {
        TeamPlayers(it.id ?: -1,
            it.name ?: "not available",
            it.position ?: "not available",
            it.nationality ?: "not available",
            it.dateOfBirth ?: "not available")
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

fun getInitials(fullName: String): String {
    if (fullName.isBlank()) {
        return ""
    }
    val nameArray = fullName.split(" ")
    return if (nameArray.size > 1) {
        val firstName = nameArray[0]
        val lastName = nameArray[1]
        val firstNameInitial = firstName[0]
        val lastNameInitial = lastName[0]
        "$firstNameInitial.$lastNameInitial"
    } else {
        val firstName = nameArray[0]
        val firstNameInitial = firstName[0]
        "$firstNameInitial."
    }
}