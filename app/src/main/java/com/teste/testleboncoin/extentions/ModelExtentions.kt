package com.teste.testleboncoin.extentions

import com.teste.testleboncoin.data.models.AlbumTitleResponse
import com.teste.testleboncoin.data.database.entitys.AlbumTitleEntity
import com.teste.testleboncoin.domain.models.AlbumTitle

fun AlbumTitleResponse.toAlbumTitleList(): List<AlbumTitle> =
    this.map { AlbumTitle(id = it.id, title = it.title, image = it.url, thumb = it.thumbnailUrl) }

fun List<AlbumTitleEntity>.toAlbumTitleList(): List<AlbumTitle> =
    this.map { AlbumTitle(id = it.id, title = it.title, image = it.image, thumb = it.thumb)}

fun List<AlbumTitle>.toAlbumTitlesEntityList(): List<AlbumTitleEntity> =
    this.map { AlbumTitleEntity(id = it.id, title = it.title, image = it.image, thumb = it.thumb)}