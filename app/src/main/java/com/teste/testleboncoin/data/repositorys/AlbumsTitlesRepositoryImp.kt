package com.teste.testleboncoin.data.repositorys

import com.teste.testleboncoin.data.network.AlbumTitlesApi
import com.teste.testleboncoin.domain.models.AlbumTitle
import com.teste.testleboncoin.domain.repositorys.AlbumTitlesRepository
import com.teste.testleboncoin.extentions.toAlbumTitleList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AlbumsTitlesRepositoryImp(
    private val albumTitlesApi: AlbumTitlesApi
) : AlbumTitlesRepository {
    override suspend fun getAlbumTitles(): Flow<List<AlbumTitle>> = flow {
        val response = albumTitlesApi.getAlbumTitles()

        if (response.isSuccessful) {
            response.body()?.let {
                emit(it.toAlbumTitleList())
            }
        } else {
            throw Exception("Error making the call")
        }
    }.flowOn(Dispatchers.IO)
}