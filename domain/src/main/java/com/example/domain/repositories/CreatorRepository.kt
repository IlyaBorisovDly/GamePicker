package com.example.domain.repositories

import com.example.domain.entities.states.Status
import com.example.domain.entities.Creator

interface CreatorRepository {

    suspend fun getCreators(): Status<List<Creator>>
}