package com.teste.testleboncoin.data.di

import androidx.room.Room
import com.teste.testleboncoin.data.database.database.AlbumTitlesDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<AlbumTitlesDatabase> {
        Room.databaseBuilder(
            get(),
            AlbumTitlesDatabase::class.java, "album_title_db"
        ).build()
    }

    single { get<AlbumTitlesDatabase>().albumTitleDao() }
}