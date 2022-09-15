package dev.amal.testtasksunrise.data.remote

import dev.amal.testtasksunrise.data.remote.dto.JokeItemDto
import retrofit2.http.GET

interface JokeApi {
    @GET("/random_ten")
    suspend fun getJokes(): List<JokeItemDto>
}