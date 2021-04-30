package com.example.android.thescores.ui.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.android.thescores.model.TeamsItem
import com.example.android.thescores.repository.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class TeamsViewModel @Inject constructor(private val repository: TeamsRepository,
                                         savedStateHandle: SavedStateHandle) : ViewModel() {

    private val competitionID = savedStateHandle.get<Int>("competition_id")

    suspend fun loadTeamPicture() : LiveData<List<TeamsItem>>{
        val teamsItemLiveData = MutableLiveData<List<TeamsItem>>()
        requireNotNull(competitionID)
        Timber.d("Id recovered is $competitionID")
        teamsItemLiveData.value = repository.getTeamsFromNetwork(competitionID).teams
        return teamsItemLiveData
    }
}