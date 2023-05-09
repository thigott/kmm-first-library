package com.thigott.myfirstkmmlibrary.di

import com.thigott.myfirstkmmlibrary.domain.usecases.GetKtorTestUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    single {
        CoroutineScope(Dispatchers.Default)
    }

    factory {
        GetKtorTestUseCase(
            scope = get(),
            repository = get()
        )
    }
}