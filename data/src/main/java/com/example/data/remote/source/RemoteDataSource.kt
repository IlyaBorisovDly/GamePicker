package com.example.data.remote.source

import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails

interface RemoteDataSource {

    suspend fun getHeaderGame(): Status<Game>

    suspend fun getPopularGames(): Status<List<Game>>

    suspend fun getOpenWorldGames(): Status<List<Game>>

    suspend fun getMultiplayerGames(): Status<List<Game>>

    suspend fun getMetacriticChoiceGames(): Status<List<Game>>

    suspend fun getFromSoftwareGames(): Status<List<Game>>

    suspend fun getPlaystationGames(): Status<List<Game>>

    suspend fun getGameDetailsById(id: Int): Status<GameDetails>
}