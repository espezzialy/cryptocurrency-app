package com.espezzialy.cryptocurrency.presentation.coin_list

import com.espezzialy.cryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error:  String = ""
)
