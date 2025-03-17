package com.teste.testleboncoin.domain.usecases

import com.teste.testleboncoin.domain.models.AlbumTitle
import com.teste.testleboncoin.domain.repositorys.AlbumTitlesRepository
import kotlinx.coroutines.flow.Flow

class GetAlbumsUseCase(private val albumTitlesRepository: AlbumTitlesRepository) {
    suspend operator fun invoke(): Flow<List<AlbumTitle>> {
        return albumTitlesRepository.getAlbumTitles()
    }
}