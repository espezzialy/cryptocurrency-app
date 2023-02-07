package com.espezzialy.cryptocurrency.data.remote

import com.espezzialy.cryptocurrency.data.remote.dto.CoinDetailDto
import com.espezzialy.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

// This is a retrofit api interface
// Just define differents functions and routes we want to access from our api
// getAllCoin , getDetailCoin(id)
interface CoinPaprikaApi {


    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>


    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto
}