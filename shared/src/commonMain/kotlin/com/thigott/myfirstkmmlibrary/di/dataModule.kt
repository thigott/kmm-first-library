package com.thigott.myfirstkmmlibrary.di

import com.thigott.myfirstkmmlibrary.data.repositories.KtorTestRepositoryImpl
import com.thigott.myfirstkmmlibrary.domain.repositories.KtorTestRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {

    single {
        HttpClient()
    }

    single<KtorTestRepository> {
        KtorTestRepositoryImpl(
            httpClient = get()
        )
    }
}