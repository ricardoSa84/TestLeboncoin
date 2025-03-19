package com.teste.testleboncoin.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teste.testleboncoin.domain.models.AlbumTitle
import com.teste.testleboncoin.domain.usecases.GetAlbumsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AlbumTitlesViewModel(private val albumTitlesUseCase: GetAlbumsUseCase) : ViewModel() {

    private val _albums = MutableStateFlow<List<AlbumTitle>>(emptyList())
    val albums: StateFlow<List<AlbumTitle>> get() = _albums

    init {
        viewModelScope.launch(Dispatchers.IO) {
            albumTitlesUseCase.invoke().collectLatest { albumTitles->
                _albums.value = albumTitles
            }
        }
    }

}