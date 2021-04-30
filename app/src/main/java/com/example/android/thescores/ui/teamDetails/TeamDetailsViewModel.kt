package com.example.android.thescores.ui.teamDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.android.thescores.model.TeamPlayers
import com.example.android.thescores.model.TeamsItem
import com.example.android.thescores.repository.TeamPlayerRepository
import com.example.android.thescores.utils.extractTeamPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle,
                                               private val teamPlayerRepository: TeamPlayerRepository )
    : ViewModel() {
    private val teamItem = savedStateHandle.get<TeamsItem>("teamItem")
    val teamItemLiveData = MutableLiveData<TeamsItem>()
    init {
        teamItemLiveData.value = teamItem
    }

    suspend fun loadTeamPlayerLiveData() : LiveData<List<TeamPlayers>>{
        val teamPlayerLiveData = MutableLiveData<List<TeamPlayers>>()
        if (teamItem?.id != null){
            val response = teamPlayerRepository.loadTeamPlayer(teamItem.id)
            teamPlayerLiveData.value = response.extractTeamPlayer()
        }
        return teamPlayerLiveData
    }
}