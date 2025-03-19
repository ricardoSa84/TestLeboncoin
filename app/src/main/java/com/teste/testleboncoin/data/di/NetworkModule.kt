package com.teste.testleboncoin.data.di

import com.teste.testleboncoin.data.network.AlbumTitlesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://static.leboncoin.fr/")
            .client(get())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(AlbumTitlesApi::class.java)
    }
}