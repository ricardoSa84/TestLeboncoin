package com.teste.testleboncoin

import android.app.Application
import com.teste.testleboncoin.data.di.databaseModule
import com.teste.testleboncoin.data.di.networkModule
import com.teste.testleboncoin.data.di.repositoryModule
import com.teste.testleboncoin.domain.di.useCaseModule
import com.teste.testleboncoin.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                viewModelModule,
                useCaseModule,
                networkModule,
                repositoryModule,
                databaseModule
            )
        }
    }
}