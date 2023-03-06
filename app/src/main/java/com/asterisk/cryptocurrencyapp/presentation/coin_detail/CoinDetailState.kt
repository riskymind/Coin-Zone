package com.asterisk.cryptocurrencyapp.presentation.coin_detail

import com.asterisk.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val isError: String = "",
)
