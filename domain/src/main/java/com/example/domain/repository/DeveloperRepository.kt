package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.developer.Developer

interface DeveloperRepository {

    suspend fun getDevelopers(): Status<List<Developer>>
}