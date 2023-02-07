package com.espezzialy.cryptocurrency.di

import com.espezzialy.cryptocurrency.common.Constants
import com.espezzialy.cryptocurrency.data.remote.CoinPaprikaApi
import com.espezzialy.cryptocurrency.data.repository.CoinRepositoryImpl
import com.espezzialy.cryptocurrency.domain.repository.CoinRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi() : CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(api)
    }

}