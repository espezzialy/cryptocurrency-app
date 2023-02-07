package com.espezzialy.cryptocurrency.domain.useCase.get_coins

import com.espezzialy.cryptocurrency.common.Resource
import com.espezzialy.cryptocurrency.domain.model.Coin
import com.espezzialy.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>>
}