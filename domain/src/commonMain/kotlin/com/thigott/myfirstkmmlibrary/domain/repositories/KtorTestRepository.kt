package com.thigott.myfirstkmmlibrary.domain.repositories

import kotlinx.coroutines.flow.Flow

interface KtorTestRepository {

    suspend fun getKtorTest(): Flow<String>
}