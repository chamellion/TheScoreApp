package com.example.android.thescores.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.thescores.model.FootballCompetition
import com.example.android.thescores.repository.CompetitionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class CompetitionViewModel @Inject constructor(private val repository: CompetitionRepository) :
    ViewModel() {

    fun loadDataFromDb(): Flow<List<FootballCompetition>> {
        return repository.loadCompetitionFromDb()
    }


    suspend fun loadDataFromNetwork(): LiveData<List<FootballCompetition>> {
        val liveData = MutableLiveData<List<FootballCompetition>>()
         liveData.value = repository.loadCompetitionFromNetwork()
        return liveData
    }
}