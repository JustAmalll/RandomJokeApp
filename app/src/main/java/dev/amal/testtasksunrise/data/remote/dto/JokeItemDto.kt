package dev.amal.testtasksunrise.data.remote.dto

import dev.amal.testtasksunrise.domain.model.JokeItem

data class JokeItemDto(
    val id: Int,
    val punchline: String,
    val setup: String,
    val type: String
)

fun JokeItemDto.toJokeItem(): JokeItem = JokeItem(
    id = id,
    punchline = punchline,
    setup = setup,
    type = type
)