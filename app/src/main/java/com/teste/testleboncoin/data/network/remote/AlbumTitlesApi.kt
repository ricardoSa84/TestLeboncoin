package com.teste.testleboncoin.data.network.remote

import com.teste.testleboncoin.data.models.AlbumTitleResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface AlbumTitlesApi {
    @GET("img/shared/technical-test.json")
    suspend fun getAlbumTitles(): Flow<List<AlbumTitleResponse>>
}