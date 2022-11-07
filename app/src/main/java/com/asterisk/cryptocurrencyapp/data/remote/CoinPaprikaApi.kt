package com.asterisk.cryptocurrencyapp.data.remote

import com.asterisk.cryptocurrencyapp.data.remote.dto.CoinDTO
import com.asterisk.cryptocurrencyapp.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/coins/{coinId}")
    suspend fun getCoinDetail(
        @Path("coinId") coinId: String,
    ): CoinDetailDTO
}