package br.com.everty.shared.utils.extensions

import br.com.everty.shared.utils.Result

fun <T, R> Result<T>.mapResult(mapper: (T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> Result.Success(mapper(data))
        is Result.Error -> this
    }
}

fun <T, R> Result<List<T>>.mapResultList(mapper: (T) -> R): Result<List<R>> {
    return when (this) {
        is Result.Success -> Result.Success(data.map(mapper))
        is Result.Error -> this
    }
}
