package com.example.android.thescores

import android.app.Application
import com.example.android.thescores.repository.CompetitionRepository
import com.example.android.thescores.utils.isOnline
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class TheScoreApplication : Application() {

    @Inject
    lateinit var repository: CompetitionRepository

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        if (isOnline(this)){
            scope.launch {
                repository.syncNetworkWithDatabase()
            }
        }

    }
}