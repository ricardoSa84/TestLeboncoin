package com.teste.testleboncoin.domain.repositorys

import com.teste.testleboncoin.domain.models.AlbumTitle
import kotlinx.coroutines.flow.Flow

interface AlbumTitlesRepository {
    fun getAlbumTitles(): Flow<List<AlbumTitle>>
}