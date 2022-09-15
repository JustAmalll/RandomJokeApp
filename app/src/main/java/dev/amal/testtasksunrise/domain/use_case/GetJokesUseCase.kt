package dev.amal.testtasksunrise.domain.use_case

import dev.amal.testtasksunrise.core.util.Resource
import dev.amal.testtasksunrise.data.remote.dto.toJokeItem
import dev.amal.testtasksunrise.domain.model.JokeItem
import dev.amal.testtasksunrise.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetJokesUseCase @Inject constructor(
    private val repository: JokeRepository
) {
    operator fun invoke(): Flow<Resource<List<JokeItem>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getJokes().map { it.toJokeItem() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}