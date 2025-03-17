package com.teste.testleboncoin.data.models


import com.fasterxml.jackson.annotation.JsonProperty

data class AlbumTitleResponseItem(
    @JsonProperty("albumId")
    val albumId: Int,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("thumbnailUrl")
    val thumbnailUrl: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("url")
    val url: String
)