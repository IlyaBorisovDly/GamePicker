package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.screenshot.Screenshot
import com.example.domain.repository.ScreenshotRepository

class ScreenshotRepositoryImpl(private val remoteDataSource: RemoteDataSource): ScreenshotRepository {

    override suspend fun getScreenshotsByGameId(id: Int): Status<List<Screenshot>> {
        return remoteDataSource.getScreenshotsByGameId(id)
    }
}