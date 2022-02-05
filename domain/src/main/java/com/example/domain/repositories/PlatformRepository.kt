package com.example.domain.repositories

import com.example.domain.entities.states.Status
import com.example.domain.entities.Platform

interface PlatformRepository {

    suspend fun getPlatforms(): Status<List<Platform>>
}