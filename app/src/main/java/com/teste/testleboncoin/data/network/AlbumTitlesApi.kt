package com.teste.testleboncoin.data.network


import com.teste.testleboncoin.data.models.AlbumTitleResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Streaming

interface AlbumTitlesApi {
    @Streaming
    @GET("img/shared/technical-test.json")
    suspend fun getAlbumTitles(): Response<AlbumTitleResponse>
}