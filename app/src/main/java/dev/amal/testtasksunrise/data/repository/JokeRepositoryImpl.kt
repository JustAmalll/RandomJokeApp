package dev.amal.testtasksunrise.data.repository

import dev.amal.testtasksunrise.data.remote.JokeApi
import dev.amal.testtasksunrise.data.remote.dto.JokeItemDto
import dev.amal.testtasksunrise.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val api: JokeApi
) : JokeRepository {
    override suspend fun getJokes(): List<JokeItemDto> = api.getJokes()
}