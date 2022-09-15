package dev.amal.testtasksunrise.domain.repository

import dev.amal.testtasksunrise.data.remote.dto.JokeItemDto

interface JokeRepository {
    suspend fun getJokes(): List<JokeItemDto>
}