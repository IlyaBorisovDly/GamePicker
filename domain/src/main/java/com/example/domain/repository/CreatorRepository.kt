package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.creator.Creator

interface CreatorRepository {

    suspend fun getCreators(): Status<List<Creator>>
}