package com.example.data.mappers

import com.example.data.entities.CreatorResponse
import com.example.domain.entities.Creator
import junit.framework.TestCase
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class CreatorMapperKtTest {

    private val mockCreator = CreatorResponse(id = 0, name = "ass", slug = "chto", image = "image")

    @Test
    fun check() {
        val creator: Creator = mockCreator.toDomain()
        assertNotNull(creator)
    }
}