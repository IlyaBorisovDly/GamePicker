package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.platform.Platform

interface PlatformRepository {

    suspend fun getPlatforms(): Status<List<Platform>>
}