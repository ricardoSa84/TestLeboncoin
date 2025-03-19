package com.teste.testleboncoin.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teste.testleboncoin.data.database.entitys.AlbumTitleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumTitleDao {

    @Query("SELECT * FROM album_titles")
    fun getAllAlbumTitles(): Flow<List<AlbumTitleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbumTitles(albumTitles: List<AlbumTitleEntity>)
}