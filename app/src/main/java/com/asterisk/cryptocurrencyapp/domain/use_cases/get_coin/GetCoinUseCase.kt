package com.asterisk.cryptocurrencyapp.domain.use_cases.get_coin

import com.asterisk.cryptocurrencyapp.common.Resource
import com.asterisk.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.asterisk.cryptocurrencyapp.domain.model.CoinDetail
import com.asterisk.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository,
) {

    suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinDetail(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An Unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}