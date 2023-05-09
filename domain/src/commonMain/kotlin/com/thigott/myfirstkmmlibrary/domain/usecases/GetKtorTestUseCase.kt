package com.thigott.myfirstkmmlibrary.domain.usecases

import com.thigott.myfirstkmmlibrary.domain.core.UseCase
import com.thigott.myfirstkmmlibrary.domain.repositories.KtorTestRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetKtorTestUseCase(
    scope: CoroutineScope,
    private val repository: KtorTestRepository
): UseCase<String, Unit>(scope = scope) {

    override suspend fun run(params: Unit?): Flow<String> = repository.getKtorTest()
}