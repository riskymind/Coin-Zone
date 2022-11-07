package com.asterisk.cryptocurrencyapp.domain.repository

import com.asterisk.cryptocurrencyapp.data.remote.dto.CoinDTO
import com.asterisk.cryptocurrencyapp.data.remote.dto.CoinDetailDTO

interface CoinRepository {

    suspend fun getCoins(): List<CoinDTO>

    suspend fun getCoinDetail(coinId: String): CoinDetailDTO
}