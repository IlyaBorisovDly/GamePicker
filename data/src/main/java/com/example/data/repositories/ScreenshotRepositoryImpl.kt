package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.states.Status
import com.example.domain.entities.Screenshot
import com.example.domain.repositories.ScreenshotRepository

class ScreenshotRepositoryImpl(private val remoteDataSource: RemoteDataSource): ScreenshotRepository {

    override suspend fun getScreenshotsByGameId(id: Int): Status<List<Screenshot>> {
        return remoteDataSource.getScreenshotsByGameId(id)
    }
}