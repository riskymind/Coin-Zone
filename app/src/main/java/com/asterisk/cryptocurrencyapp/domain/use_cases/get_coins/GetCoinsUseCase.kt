package com.asterisk.cryptocurrencyapp.domain.use_cases.get_coins

import com.asterisk.cryptocurrencyapp.common.Resource
import com.asterisk.cryptocurrencyapp.data.remote.dto.toCoin
import com.asterisk.cryptocurrencyapp.domain.model.Coin
import com.asterisk.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository,
) {

    suspend operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An expected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach the server, check your internet connection"))
        }
    }

}