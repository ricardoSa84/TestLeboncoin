package com.teste.testleboncoin.data.di

import com.teste.testleboncoin.data.repositorys.AlbumsTitlesRepositoryImp
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::AlbumsTitlesRepositoryImp)
}