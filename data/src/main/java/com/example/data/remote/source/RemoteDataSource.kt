package com.example.data.remote.source

import com.example.domain.GameTag
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.screenshot.Screenshot

interface RemoteDataSource {

    suspend fun getGameById(id: Int): Status<Game>

    suspend fun getGameDetailsById(id: Int): Status<GameDetails>

    suspend fun getScreenshotsByGameId(id: Int): Status<List<Screenshot>>

    suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>>
}