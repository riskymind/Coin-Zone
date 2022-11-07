package com.asterisk.cryptocurrencyapp.data.repository

import com.asterisk.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.asterisk.cryptocurrencyapp.data.remote.dto.CoinDTO
import com.asterisk.cryptocurrencyapp.data.remote.dto.CoinDetailDTO
import com.asterisk.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi,
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDTO> {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDTO {
        return coinPaprikaApi.getCoinDetail(coinId)
    }

}