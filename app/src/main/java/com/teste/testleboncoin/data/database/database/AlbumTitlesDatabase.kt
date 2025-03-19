package com.teste.testleboncoin.data.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teste.testleboncoin.data.database.daos.AlbumTitleDao
import com.teste.testleboncoin.data.database.entitys.AlbumTitleEntity

@Database(entities = [AlbumTitleEntity::class], version = 1, exportSchema = false)
abstract class AlbumTitlesDatabase : RoomDatabase() {
    abstract fun albumTitleDao(): AlbumTitleDao
}