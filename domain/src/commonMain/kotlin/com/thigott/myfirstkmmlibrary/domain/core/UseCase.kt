package com.thigott.myfirstkmmlibrary.domain.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class UseCase<T, in Params>(private val scope: CoroutineScope): KoinComponent {

    abstract suspend fun run(params: Params? = null): Flow<T>

    operator fun invoke(
        params: Params? = null,
        onError: ((Throwable) -> Unit) = {},
        onSuccess: (T) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Default) {
            try {
                run(params).collect {
                    withContext(Dispatchers.Main) {
                        onSuccess(it)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }

    }

    fun cancel() = scope.coroutineContext.cancelChildren()
}