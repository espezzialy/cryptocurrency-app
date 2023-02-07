package com.espezzialy.cryptocurrency.presentation.coin_detail

import com.espezzialy.cryptocurrency.domain.model.Coin
import com.espezzialy.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error:  String = ""
)
