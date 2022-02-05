package com.example.data.remote.sources

import com.example.domain.entities.enums.GameTag
import com.example.domain.entities.states.Status
import com.example.domain.entities.Publisher
import com.example.domain.entities.Creator
import com.example.domain.entities.Developer
import com.example.domain.entities.Game
import com.example.domain.entities.GameDetails
import com.example.domain.entities.Genre
import com.example.domain.entities.Platform
import com.example.domain.entities.Screenshot

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