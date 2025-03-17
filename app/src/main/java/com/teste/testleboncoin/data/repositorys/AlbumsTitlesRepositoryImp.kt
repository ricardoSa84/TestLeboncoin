package com.teste.testleboncoin.data.repositorys

import com.teste.testleboncoin.domain.models.AlbumTitle
import com.teste.testleboncoin.domain.repositorys.AlbumTitlesRepository
import kotlinx.coroutines.flow.Flow

class AlbumsTitlesRepositoryImp : AlbumTitlesRepository {
    override fun getAlbumTitles(): Flow<List<AlbumTitle>> {
        TODO("Not yet implemented")
    }

}