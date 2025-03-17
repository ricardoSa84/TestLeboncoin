package com.teste.testleboncoin.data.di

import com.teste.testleboncoin.data.network.remote.AlbumTitlesApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(AlbumTitlesApi::class.java)
    }
}