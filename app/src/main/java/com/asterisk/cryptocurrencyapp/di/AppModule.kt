package com.asterisk.cryptocurrencyapp.di

import android.content.Context
import com.asterisk.cryptocurrencyapp.CryptoCurrencyApplication
import com.asterisk.cryptocurrencyapp.common.Constants.BASE_URL
import com.asterisk.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.asterisk.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.asterisk.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApplication(@ApplicationContext context: Context): CryptoCurrencyApplication {
        return context as CryptoCurrencyApplication
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor)
            callTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
        }
        return okHttpClient.build()
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        converter: Converter.Factory, okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converter)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(retrofit: Retrofit): CoinPaprikaApi {
        return retrofit.create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinPaprikaApi: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(coinPaprikaApi)
    }
}