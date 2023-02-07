package com.espezzialy.cryptocurrency.domain.repository

import com.espezzialy.cryptocurrency.data.remote.dto.CoinDetailDto
import com.espezzialy.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}