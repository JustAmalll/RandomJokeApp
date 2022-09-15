package dev.amal.testtasksunrise.presentation

import dev.amal.testtasksunrise.domain.model.JokeItem

data class JokesListState(
    val isLoading: Boolean = false,
    val jokes: List<JokeItem> = emptyList(),
    val error: String = ""
)