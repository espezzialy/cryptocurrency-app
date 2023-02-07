package com.espezzialy.cryptocurrency.domain.useCase.get_coin

import com.espezzialy.cryptocurrency.common.Resource
import com.espezzialy.cryptocurrency.data.remote.dto.toCoin
import com.espezzialy.cryptocurrency.data.remote.dto.toCoinDetail
import com.espezzialy.cryptocurrency.domain.model.Coin
import com.espezzialy.cryptocurrency.domain.model.CoinDetail
import com.espezzialy.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))

        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }
    }
}