package com.teste.testleboncoin.domain.di

import com.teste.testleboncoin.domain.usecases.GetAlbumsUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::GetAlbumsUseCase)
}