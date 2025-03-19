package com.teste.testleboncoin.domain.usecases

import android.util.Log
import com.teste.testleboncoin.data.database.database.AlbumTitlesDatabase
import com.teste.testleboncoin.domain.models.AlbumTitle
import com.teste.testleboncoin.domain.repositorys.AlbumTitlesRepository
import com.teste.testleboncoin.extentions.toAlbumTitleList
import com.teste.testleboncoin.extentions.toAlbumTitlesEntityList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map

class GetAlbumsUseCase(
    private val albumTitlesRepository: AlbumTitlesRepository,
    private val albumTitlesDatabase: AlbumTitlesDatabase
) {
    suspend operator fun invoke(): Flow<List<AlbumTitle>> {
        albumTitlesRepository.getAlbumTitles().collectLatest { remoteAlbumTitles->
            try {
                albumTitlesDatabase.albumTitleDao().insertAlbumTitles(remoteAlbumTitles.toAlbumTitlesEntityList())
            }catch (ex:Exception){
                //todo: handle this better :D
                Log.d("Call error",ex.message?:"Boommmmm")
            }
        }
        return albumTitlesDatabase.albumTitleDao().getAllAlbumTitles().map { it.toAlbumTitleList() }
    }
}