package com.teste.testleboncoin.data.database.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album_titles")
data class AlbumTitleEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val image: String,
    val thumb: String
)