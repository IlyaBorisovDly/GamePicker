package com.example.data.remote.source

import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.screenshot.Screenshot

interface RemoteDataSource {

    suspend fun getGameById(id: Int): Status<Game>

    suspend fun getPopularGames(): Status<List<Game>>

    suspend fun getOpenWorldGames(): Status<List<Game>>

    suspend fun getMultiplayerGames(): Status<List<Game>>

    suspend fun getMetacriticChoiceGames(): Status<List<Game>>

    suspend fun getFromSoftwareGames(): Status<List<Game>>

    suspend fun getPlaystationGames(): Status<List<Game>>

    suspend fun getGameDetailsById(id: Int): Status<GameDetails>

    suspend fun getScreenshotsById(id: Int): Status<List<Screenshot>>
}