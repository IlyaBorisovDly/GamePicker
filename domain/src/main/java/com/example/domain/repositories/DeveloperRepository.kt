package com.example.domain.repositories

import com.example.domain.entities.states.Status
import com.example.domain.entities.Developer

interface DeveloperRepository {

    suspend fun getDevelopers(): Status<List<Developer>>
}