package com.example.data.mapper

import com.example.data.entity.game.PlatformResponse
import com.example.domain.entity.game.Platform

fun PlatformResponse.toDomain() = Platform(id =  id, name = name)
