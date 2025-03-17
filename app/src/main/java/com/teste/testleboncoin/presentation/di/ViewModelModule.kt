package com.teste.testleboncoin.presentation.di

import com.teste.testleboncoin.presentation.viewmodels.AlbumTitlesViewModel
import org.koin.dsl.module

val viewModelModule = module{
    single{ AlbumTitlesViewModel() }

}