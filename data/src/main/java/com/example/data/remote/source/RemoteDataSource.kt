package com.example.data.remote.source

import com.example.domain.GameTag
import com.example.domain.Status
import com.example.domain.entity.Publisher
import com.example.domain.entity.creator.Creator
import com.example.domain.entity.developer.Developer
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.genre.Genre
import com.example.domain.entity.platform.Platform
import com.example.domain.entity.screenshot.Screenshot

interface RemoteDataSource {

    suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>>

    suspend fun getGameById(id: Int): Status<Game>

    suspend fun getGameDetailsById(id: Int): Status<GameDetails>

    suspend fun getScreenshotsByGameId(id: Int): Status<List<Screenshot>>

    suspend fun getCreators(): Status<List<Creator>>

    suspend fun getPublishers(): Status<List<Publisher>>

    suspend fun getGenres(): Status<List<Genre>>

    suspend fun getDevelopers(): Status<List<Developer>>

    suspend fun getPlatforms(): Status<List<Platform>>
}