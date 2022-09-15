package dev.amal.testtasksunrise.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.testtasksunrise.core.util.Resource
import dev.amal.testtasksunrise.domain.use_case.GetJokesUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class JokeListViewModel @Inject constructor(
    private val getJokesUseCase: GetJokesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(JokesListState())
    val state: State<JokesListState> = _state

    init {
        getJokes()
    }

    fun getJokes() {
        getJokesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = JokesListState(jokes = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = JokesListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = JokesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}