package com.teste.testleboncoin.presentation.di

import com.teste.testleboncoin.presentation.viewmodels.AlbumTitlesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module{
    viewModelOf(::AlbumTitlesViewModel){}
}